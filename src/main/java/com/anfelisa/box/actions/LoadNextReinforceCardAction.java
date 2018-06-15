package com.anfelisa.box.actions;

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

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.NextReinforceCardData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.INextReinforceCardModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/box")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadNextReinforceCardAction extends AbstractLoadNextReinforceCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextReinforceCardAction.class);

	public LoadNextReinforceCardAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/next-reinforce-card")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("boxId") String boxId) throws JsonProcessingException {
		this.actionData = new NextReinforceCardData(uuid).withBoxId(boxId).withUserId(user.getUserId());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(getHandle(), actionData.getBoxId());
		if (box == null) {
			throwBadRequest("box does not exist");
		}
		if (!box.getUserId().equals(actionData.getUserId())) {
			throwUnauthorized();
		}

		INextReinforceCardModel nextCard = daoProvider.getCustomReinforceCardDao().selectFirstScheduledCard(getHandle(),
				actionData.getBoxId());
		if (nextCard != null) {
			this.actionData.setGiven(nextCard.getGiven());
			this.actionData.setImage(nextCard.getImage());
			this.actionData.setLastQuality(nextCard.getLastQuality());
			this.actionData.setWanted(nextCard.getWanted());
			this.actionData.setChangeDate(nextCard.getChangeDate());
			this.actionData.setReinforceCardId(nextCard.getReinforceCardId());
		}
	}

}

/* S.D.G. */
