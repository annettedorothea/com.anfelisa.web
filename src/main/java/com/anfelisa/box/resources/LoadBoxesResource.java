package com.anfelisa.box.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.LoadBoxesAction;
import com.anfelisa.box.data.BoxListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadBoxesResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxesResource.class);

	public LoadBoxesResource( DBI jdbi ) {
		super(jdbi);
	}

	@GET
	@Timed
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema) throws JsonProcessingException {
		BoxListData actionParam = new BoxListData(user.getUsername(), uuid, schema);
		return new LoadBoxesAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */