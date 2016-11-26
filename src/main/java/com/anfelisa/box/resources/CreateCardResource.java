package com.anfelisa.box.resources;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.CreateCardAction;
import com.anfelisa.box.data.CardCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateCardResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardResource.class);

	public CreateCardResource(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/create")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response post( @NotNull CardCreationData actionParam) throws JsonProcessingException {
		return new CreateCardAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */
