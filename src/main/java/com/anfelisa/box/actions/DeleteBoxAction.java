package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.DeleteBoxData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteBoxAction extends AbstractDeleteBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteBoxAction.class);

	public DeleteBoxAction(DBI jdbi) {
		super(jdbi);
	}

	@DELETE
	@Timed
	@Path("/delete")
	@PermitAll
	public Response delete(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("boxId") Integer boxId)
			throws JsonProcessingException {
		this.actionData = new DeleteBoxData(uuid, schema).withBoxId(boxId).withCredentialsRole(user.getRole())
				.withCredentialsUsername(user.getUsername());
		return this.apply();
	}

}

/* S.D.G. */
