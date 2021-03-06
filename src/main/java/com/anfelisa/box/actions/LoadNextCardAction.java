package com.anfelisa.box.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.INextCardViewModel;
import com.anfelisa.box.models.ITodaysCardsStatusModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class LoadNextCardAction extends AbstractLoadNextCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextCardAction.class);

	public LoadNextCardAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, actionData.getBoxId());
		if (box == null) {
			throwIllegalArgumentException("boxDoesNotExist");
		}
		if (!box.getUserId().equals(actionData.getUserId())) {
			throwSecurityException();
		}
		actionData.setReverse(box.getReverse());

		INextCardViewModel nextCard = daoProvider.getScheduledCardDao().selectFirstScheduledCard(readonlyHandle,
				actionData.getBoxId(), actionData.getTodayAtMidnightInUTC());
		if (nextCard == null) {
			nextCard = daoProvider.getReinforceCardDao().selectFirstReinforceCard(readonlyHandle,
					actionData.getBoxId());
		}
		if (nextCard != null) {
			this.actionData.mapFrom(nextCard);
			if (box.getReverse()) {
				this.actionData.setGiven(nextCard.getWanted());
				this.actionData.setWanted(nextCard.getGiven());
			}
		}
		ITodaysCardsStatusModel todaysCardsStatus = daoProvider.getBoxDao().todaysCardsStatus(readonlyHandle, box.getBoxId(), actionData.getTodayAtMidnightInUTC());
		this.actionData.setAllTodaysCards(todaysCardsStatus.getAllTodaysCards());
		this.actionData.setOpenTodaysCards(todaysCardsStatus.getOpenTodaysCards());
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
