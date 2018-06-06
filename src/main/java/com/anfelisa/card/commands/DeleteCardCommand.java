package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.CardDeleteData;
import com.anfelisa.card.models.ICardModel;

public class DeleteCardCommand extends AbstractDeleteCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardCommand.class);

	public DeleteCardCommand(CardDeleteData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICardModel card = daoProvider.getCardDao().selectByCardId(getHandle(), commandData.getCardId());
		if (card == null) {
			throwBadRequest("card does not exist");
		}
		this.commandData.setCardIndex(card.getCardIndex());
		this.commandData.setCategoryId(card.getCategoryId());
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */