/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.box.actions;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.jdbi.v3.core.Jdbi;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.Action;
import de.acegen.App;
import de.acegen.CustomAppConfiguration;
import de.acegen.DatabaseHandle;
import de.acegen.E2E;
import de.acegen.HttpMethod;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ITimelineItem;
import de.acegen.JodaObjectMapper;
import de.acegen.ServerConfiguration;
import de.acegen.ViewProvider;
import de.acegen.NotReplayableDataProvider;
import de.acegen.PersistenceHandle;
import de.acegen.PersistenceConnection;

import de.acegen.auth.AuthUser;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.auth.Auth;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.jdbi.v3.core.Handle;


import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.data.BoxUpdateData;
import com.anfelisa.box.commands.UpdateBoxCommand;

@Path("/box/update")
@SuppressWarnings("unused")
public abstract class AbstractUpdateBoxAction extends Action<IBoxUpdateData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUpdateBoxAction.class);
	
	private DatabaseHandle databaseHandle;
	private PersistenceConnection persistenceConnection;
	protected JodaObjectMapper mapper;
	protected CustomAppConfiguration appConfiguration;
	protected IDaoProvider daoProvider;
	private ViewProvider viewProvider;
	private E2E e2e;
	

	public AbstractUpdateBoxAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.box.actions.UpdateBoxAction", HttpMethod.PUT);
		this.persistenceConnection = persistenceConnection;
		mapper = new JodaObjectMapper();
		this.appConfiguration = appConfiguration;
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
		this.e2e = e2e;
	}

	@Override
	public ICommand getCommand() {
		return new UpdateBoxCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	public void setActionData(IDataContainer data) {
		this.actionData = (IBoxUpdateData)data;
	}

	@PUT
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBoxResource(
			@Auth AuthUser authUser, 
			@NotNull IBoxUpdateData payload)
			throws JsonProcessingException {
		this.actionData = new BoxUpdateData(payload.getUuid());
		this.actionData.setMaxInterval(payload.getMaxInterval());
		this.actionData.setMaxCardsPerDay(payload.getMaxCardsPerDay());
		this.actionData.setBoxId(payload.getBoxId());
		this.actionData.setCategoryId(payload.getCategoryId());
		this.actionData.setCategoryName(payload.getCategoryName());
		this.actionData.setDictionaryLookup(payload.getDictionaryLookup());
		this.actionData.setGivenLanguage(payload.getGivenLanguage());
		this.actionData.setWantedLanguage(payload.getWantedLanguage());
		this.actionData.setUserId(authUser.getUserId());
		return this.apply();
	}

	public Response apply() {
		databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi());
		databaseHandle.beginTransaction();
		try {
			if (ServerConfiguration.DEV.equals(appConfiguration.getServerConfiguration().getMode())
					|| ServerConfiguration.LIVE.equals(appConfiguration.getServerConfiguration().getMode())) {
				if (appConfiguration.getServerConfiguration().writeTimeline()) {
					if (daoProvider.getAceDao().contains(databaseHandle.getHandle(), this.actionData.getUuid())) {
						databaseHandle.commitTransaction();
						throwBadRequest("uuid already exists - please choose another one");
					}
				}
				
				this.actionData.setSystemTime(new DateTime());
				this.initActionData();
			} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
				ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
				IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
				IBoxUpdateData originalActionData = (IBoxUpdateData)originalData;
				this.actionData.setSystemTime(originalActionData.getSystemTime());
			} else if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
				if (NotReplayableDataProvider.getSystemTime() != null) {
					this.actionData.setSystemTime(NotReplayableDataProvider.getSystemTime());
				}
			}
			if (appConfiguration.getServerConfiguration().writeTimeline()) {
				daoProvider.getAceDao().addActionToTimeline(this, this.databaseHandle.getTimelineHandle());
			}
			ICommand command = this.getCommand();
			command.execute(this.databaseHandle.getReadonlyHandle(), this.databaseHandle.getTimelineHandle());
			command.publishEvents(this.databaseHandle.getHandle(), this.databaseHandle.getTimelineHandle());
			Response response = Response.ok(this.createReponse()).build();
			databaseHandle.commitTransaction();
			return response;
		} catch (WebApplicationException x) {
			LOG.error(actionName + " failed " + x.getMessage());
			try {
				databaseHandle.rollbackTransaction();
				if (appConfiguration.getServerConfiguration().writeError()) {
					daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());
				}
				App.reportException(x);
			} catch (Exception ex) {
				LOG.error("failed to rollback or to save or report exception " + ex.getMessage());
			}
			return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
		} catch (Exception x) {
			LOG.error(actionName + " failed " + x.getMessage());
			try {
				databaseHandle.rollbackTransaction();
				if (appConfiguration.getServerConfiguration().writeError()) {
					daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());
				}
				App.reportException(x);
			} catch (Exception ex) {
				LOG.error("failed to rollback or to save or report exception " + ex.getMessage());
			}
			return Response.status(500).entity(x.getMessage()).build();
		} finally {
			databaseHandle.close();
			if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
				NotReplayableDataProvider.clear();
			}
		}
	}
	

}




/******* S.D.G. *******/



