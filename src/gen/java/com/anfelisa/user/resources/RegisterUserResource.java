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
	
	
	
	
	package com.anfelisa.user.resources;
	
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
	

	import com.codahale.metrics.annotation.Timed;
	import com.codahale.metrics.annotation.Metered;
	import com.codahale.metrics.annotation.ExceptionMetered;
	import com.codahale.metrics.annotation.ResponseMetered;

	import com.fasterxml.jackson.core.JsonProcessingException;
	
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.DELETE;
	
	import com.anfelisa.user.data.IUserRegistrationData;
	import com.anfelisa.user.data.UserRegistrationData;
	
	import de.acegen.Resource;
	
	@Path("/users/register")
	@SuppressWarnings("unused")
	public class RegisterUserResource extends Resource {
	
		static final Logger LOG = LoggerFactory.getLogger(RegisterUserResource.class);
		
		private PersistenceConnection persistenceConnection;
		private CustomAppConfiguration appConfiguration;
		private IDaoProvider daoProvider;
		private ViewProvider viewProvider;
		private E2E e2e;

	public RegisterUserResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
			this.e2e = e2e;
		}
	
	@POST
	@Timed(name = "RegisterUserActionTimed")
	@Metered(name = "RegisterUserActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUserResource(
			IUserRegistrationData payload)
			throws JsonProcessingException {
		if (payload == null) {
			return badRequest("payload must not be null");
		}
		com.anfelisa.user.data.IUserRegistrationData actionData = new UserRegistrationData(payload.getUuid());
		
		if (StringUtils.isBlank(payload.getPassword()) || "null".equals(payload.getPassword())) {
			return badRequest("password is mandatory");
		}
		actionData.setPassword(payload.getPassword());
		
		if (StringUtils.isBlank(payload.getUsername()) || "null".equals(payload.getUsername())) {
			return badRequest("username is mandatory");
		}
		actionData.setUsername(payload.getUsername());
		
		if (StringUtils.isBlank(payload.getEmail()) || "null".equals(payload.getEmail())) {
			return badRequest("email is mandatory");
		}
		actionData.setEmail(payload.getEmail());
		
		if (StringUtils.isBlank(payload.getLanguage()) || "null".equals(payload.getLanguage())) {
			return badRequest("language is mandatory");
		}
		actionData.setLanguage(payload.getLanguage());
		
		com.anfelisa.user.actions.RegisterUserAction action = new com.anfelisa.user.actions.RegisterUserAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
		action.setActionData(actionData);
		try {
			action.apply();
			return ok();
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


	