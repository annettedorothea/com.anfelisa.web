package com.anfelisa.box.actions;

import javax.annotation.security.RolesAllowed;
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
import com.anfelisa.box.data.CardIdData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteCardAction extends AbstractDeleteCardAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardAction.class);

	public DeleteCardAction(DBI jdbi) {
		super(jdbi);
	}

	@DELETE
	@Timed
	@Path("/delete")
	@RolesAllowed({ AuthUser.ADMIN, AuthUser.AUTHOR })
	public Response delete(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("testId") Integer testId, @NotNull @QueryParam("contentHash") String contentHash) throws JsonProcessingException {
		this.actionData = new CardIdData(uuid, schema).withTestId(testId).withContentHash(contentHash);
		return this.apply();
	}

}

/*       S.D.G.       */
