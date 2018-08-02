package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
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

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.ScoreReinforceCardData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/reinforce-card")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class ScoreReinforceCardAction extends AbstractScoreReinforceCardAction {

	static final Logger LOG = LoggerFactory.getLogger(ScoreReinforceCardAction.class);

	public ScoreReinforceCardAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@POST
	@Timed
	@Path("/score")
	@PermitAll
	public Response post(@Auth AuthUser user, @NotNull ScoreReinforceCardData scoreReinforceCardData) throws JsonProcessingException {
		this.actionData = scoreReinforceCardData.withUserId(user.getUserId());
		return this.apply();
	}

}

/* S.D.G. */
