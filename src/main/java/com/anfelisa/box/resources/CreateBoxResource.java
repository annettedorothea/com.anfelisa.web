package com.anfelisa.box.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.CreateBoxAction;
import com.anfelisa.box.data.BoxCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateBoxResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxResource.class);

	public CreateBoxResource(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/create")
	@PermitAll
	public Response post(@NotNull BoxCreationData actionParam, @Auth AuthUser user) throws JsonProcessingException {
		if (user.getRole().equals(AuthUser.STUDENT) && !actionParam.getUsername().equals(user.getUsername())) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		return new CreateBoxAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */
