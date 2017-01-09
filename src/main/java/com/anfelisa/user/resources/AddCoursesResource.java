package com.anfelisa.user.resources;

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

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.actions.AddCoursesAction;
import com.anfelisa.user.data.AddCoursesData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/users")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class AddCoursesResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(AddCoursesResource.class);

	public AddCoursesResource( DBI jdbi ) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/courses")
	@PermitAll
	public Response post(@Auth AuthUser user, @NotNull AddCoursesData addCoursesData) throws JsonProcessingException {
		if (user.getRole().equals(AuthUser.STUDENT) && !addCoursesData.getUsername().equals(user.getUsername())) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		DatabaseHandle handle = this.createDatabaseHandle();
		return new AddCoursesAction(addCoursesData, handle).apply();
	}

}

/*       S.D.G.       */
