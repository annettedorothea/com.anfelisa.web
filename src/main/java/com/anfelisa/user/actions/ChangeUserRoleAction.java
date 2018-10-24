package com.anfelisa.user.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.ChangeUserRoleData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class ChangeUserRoleAction extends AbstractChangeUserRoleAction {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleAction.class);

	public ChangeUserRoleAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@PUT
	@Timed
	@Path("/role")
	@RolesAllowed({ AuthUser.ADMIN })
	public Response put(@Auth AuthUser user, @NotNull ChangeUserRoleData changeUserRoleData)
			throws JsonProcessingException {
		this.actionData = changeUserRoleData.withAuthRole(user.getRole()).withAuthUserId(user.getUserId());
		return this.apply();
	}

}

/* S.D.G. */
