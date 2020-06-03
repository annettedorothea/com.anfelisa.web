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
	
	
	
	
	package com.anfelisa.category.resources;
	
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
	import de.acegen.E2E;
	import de.acegen.IDaoProvider;
	import de.acegen.IDataContainer;
	import de.acegen.ViewProvider;
	import de.acegen.PersistenceConnection;
	import de.acegen.PersistenceHandle;
	import de.acegen.ReadAction;
	import de.acegen.ITimelineItem;
	import de.acegen.NotReplayableDataProvider;
	
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
	
	import com.anfelisa.category.data.ICategoryTreeData;
	import com.anfelisa.category.data.CategoryTreeData;
	
	import de.acegen.Resource;
	
	@Path("/category/tree")
	@SuppressWarnings("unused")
	public class GetCategoryTreeResource extends Resource {
	
		static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeResource.class);
		
		private PersistenceConnection persistenceConnection;
		private CustomAppConfiguration appConfiguration;
		private IDaoProvider daoProvider;
		private ViewProvider viewProvider;
		private E2E e2e;

	public GetCategoryTreeResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
			this.e2e = e2e;
		}
	
	@GET
	@Timed(name = "GetCategoryTreeActionTimed")
	@Metered(name = "GetCategoryTreeActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCategoryTreeResource(
			@Auth AuthUser authUser, 
			@QueryParam("rootCategoryId") String rootCategoryId, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			return badRequest("uuid must not be blank or null");
		}
		com.anfelisa.category.data.ICategoryTreeData actionData = new CategoryTreeData(uuid);
		
		if (StringUtils.isBlank(rootCategoryId) || "null".equals(rootCategoryId)) {
			return badRequest("rootCategoryId is mandatory");
		}
		actionData.setRootCategoryId(rootCategoryId);
		actionData.setUserId(authUser.getUserId());
		
		com.anfelisa.category.actions.GetCategoryTreeAction action = new com.anfelisa.category.actions.GetCategoryTreeAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
		action.setActionData(actionData);
		try {
			action.apply();
			return Response.ok(new com.anfelisa.category.data.GetCategoryTreeResponse(action.getActionData())).build();
		} catch (IllegalArgumentException x) {
			LOG.error("bad request due to {} ", x.getMessage());
			return badRequest(x.getMessage());
		} catch (SecurityException x) {
			LOG.error("unauthorized due to {} ", x.getMessage());
			return unauthorized();
		} catch (Exception x) {
			LOG.error("internal server error due to {} ", x.getMessage());
			return internalServerError(x);
		}
	}

}




/******* S.D.G. *******/


	