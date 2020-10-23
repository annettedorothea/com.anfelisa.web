/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.box.resources;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.ITimelineItem;
import de.acegen.NonDeterministicDataProvider;

import de.acegen.auth.AuthUser;
import io.dropwizard.auth.Auth;

import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.ResponseMetered;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.anfelisa.box.data.INextCardData;
import com.anfelisa.box.data.NextCardData;

import de.acegen.Resource;

@Path("/box/next-card")
@SuppressWarnings("unused")
public class LoadNextCardResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextCardResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public LoadNextCardResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@GET
	@Timed(name = "LoadNextCardActionTimed")
	@Metered(name = "LoadNextCardActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loadNextCardResource(
			@Auth AuthUser authUser, 
			@QueryParam("boxId") String boxId, 
			@QueryParam("todayAtMidnightInUTC") String todayAtMidnightInUTC, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		com.anfelisa.box.data.INextCardData actionData = new NextCardData(uuid);
		
		if (StringUtils.isBlank(boxId) || "null".equals(boxId)) {
			return badRequest("boxId is mandatory");
		}
		actionData.setBoxId(boxId);
		
		if (StringUtils.isBlank(todayAtMidnightInUTC) || "null".equals(todayAtMidnightInUTC)) {
			return badRequest("todayAtMidnightInUTC is mandatory");
		}
		if (StringUtils.isNotBlank(todayAtMidnightInUTC)) {
			try {
				actionData.setTodayAtMidnightInUTC(LocalDateTime.parse(todayAtMidnightInUTC, DateTimeFormatter.ISO_DATE_TIME));
			} catch (Exception x) {
				LOG.warn("failed to parse dateTime todayAtMidnightInUTC - {}", todayAtMidnightInUTC);
			}
		}
		actionData.setUserId(authUser.getUserId());
		
		com.anfelisa.box.actions.LoadNextCardAction action = new com.anfelisa.box.actions.LoadNextCardAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
		action.setActionData(actionData);
		try {
			action.apply();
			return Response.ok(new com.anfelisa.box.data.LoadNextCardResponse(action.getActionData())).build();
		} catch (IllegalArgumentException x) {
			LOG.error("bad request due to {} ", x.getMessage());
			return badRequest(x.getMessage());
		} catch (SecurityException x) {
			LOG.error("unauthorized due to {} ", x.getMessage());
			return unauthorized("authorization needed for /box/next-card");
		} catch (Exception x) {
			LOG.error("internal server error due to {} ", x.getMessage());
			return internalServerError(x);
		}
	}
}




/******* S.D.G. *******/


