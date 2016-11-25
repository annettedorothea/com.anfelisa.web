package com.anfelisa.course.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.actions.LoadPrivateCoursesAction;
import com.anfelisa.course.data.MyCourseListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPrivateCoursesResource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateCoursesResource.class);

	@GET
	@Timed
	@Path("/private")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema) throws JsonProcessingException {
		MyCourseListData actionParam = new MyCourseListData(user.getUsername(), uuid, schema);
		return new LoadPrivateCoursesAction(actionParam, DatabaseService.getDatabaseHandle()).apply();
	}

}

/* S.D.G. */