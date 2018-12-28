package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.CardUpdateData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class UpdateCardCommand extends AbstractUpdateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCardCommand.class);

	public UpdateCardCommand(CardUpdateData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICardModel card = daoProvider.getCardDao().selectByCardId(getHandle(), commandData.getCardId());
		if (card == null) {
			throwBadRequest("cardDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(getHandle(), card.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
