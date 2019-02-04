package com.anfelisa.card.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.ICardDeleteData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class DeleteCardCommand extends AbstractDeleteCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardCommand.class);

	public DeleteCardCommand(ICardDeleteData actionData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionData, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		ICardModel card = daoProvider.getCardDao().selectByCardId(readonlyHandle, commandData.getCardId());
		if (card == null) {
			throwBadRequest("cardDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, card.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		this.commandData.setCardIndex(card.getCardIndex());
		this.commandData.setCategoryId(card.getCategoryId());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
