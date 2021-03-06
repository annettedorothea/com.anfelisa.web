/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/

package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.card.data.ICardUpdatePriorityData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class UpdateCardPriorityCommand extends AbstractUpdateCardPriorityCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCardPriorityCommand.class);

	public UpdateCardPriorityCommand(ICardUpdatePriorityData commandData, IDaoProvider daoProvider,
			ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		ICardModel card = daoProvider.getCardDao().selectByCardId(readonlyHandle, commandData.getCardId());
		if (card == null) {
			throwIllegalArgumentException("cardDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, card.getRootCategoryId(), commandData.getUserId());
		if (access == null || !access.getEditable()) {
			throwSecurityException();
		}
		if (this.commandData.getPriority() != null
				&& (this.commandData.getPriority() < 1 || this.commandData.getPriority() > 3)) {
			throwIllegalArgumentException("invalidPriority");
		}
		this.addOkOutcome();
	}

}

/******* S.D.G. *******/
