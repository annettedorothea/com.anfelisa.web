package com.anfelisa.category.actions;

import javax.annotation.security.RolesAllowed;
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

import com.anfelisa.auth.AuthUser;
import com.anfelisa.category.data.CategoryMoveData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/category")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class MoveCategoryAction extends AbstractMoveCategoryAction {

	static final Logger LOG = LoggerFactory.getLogger(MoveCategoryAction.class);

	public MoveCategoryAction(DBI jdbi) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/move")
	@RolesAllowed({ AuthUser.AUTHOR })
	public Response put(@Auth AuthUser user, @NotNull CategoryMoveData categoryMoveData) throws JsonProcessingException {
		this.actionData = categoryMoveData;
		return this.apply();
	}


}

/*       S.D.G.       */
