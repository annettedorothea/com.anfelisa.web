package com.anfelisa.test.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
import com.anfelisa.test.actions.CreateTestAction;
import com.anfelisa.test.data.TestCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateTestResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(CreateTestResource.class);

	public CreateTestResource(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/create")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response post(@NotNull TestCreationData testCreationData) throws JsonProcessingException, UnsupportedEncodingException {
		String decodedHtml = URLDecoder.decode( testCreationData.getHtml(), "UTF-8" );
		testCreationData.setHtml(decodedHtml);
		return new CreateTestAction(testCreationData, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */
