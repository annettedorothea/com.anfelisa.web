package com.anfelisa.user.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.actions.UpdatePasswordAction;
import com.anfelisa.user.data.PasswordUpdateData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdatePasswordResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(UpdatePasswordResource.class);

	public UpdatePasswordResource(DBI jdbi) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/password")
	@PermitAll
	public Response put(@Auth AuthUser user, @NotNull PasswordUpdateData passwordUpdateData)
			throws JsonProcessingException {
		passwordUpdateData.setUsername(user.getUsername());
		DatabaseHandle handle = this.createDatabaseHandle();
		return new UpdatePasswordAction(passwordUpdateData, handle).apply();
	}

}

/* S.D.G. */