package com.anfelisa.box.commands;

import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.PostponeCardsData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.INextCardModel;

public class PostponeCardsCommand extends AbstractPostponeCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(PostponeCardsCommand.class);

	public PostponeCardsCommand(PostponeCardsData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(this.getHandle(), this.commandData.getBoxId());
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwUnauthorized();
		}
		INextCardModel nextCard = daoProvider.getCustomScheduledCardDao().selectFirstScheduledCard(getHandle(),
				commandData.getBoxId(), commandData.getToday());
		if (nextCard != null) {
			int days = Days.daysBetween(nextCard.getScheduledDate(), commandData.getToday()).getDays();
			if (days > 0) {
				this.commandData.setDays(days);
				this.commandData.setOutcome(ok);
			} else {
				this.commandData.setOutcome(noDelay);
			}
		} else {
			this.commandData.setOutcome(noDelay);
		}
	}

}

/*       S.D.G.       */
