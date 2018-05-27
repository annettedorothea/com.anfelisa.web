package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.PostponeCardsData;
import com.anfelisa.box.models.IBoxModel;

public class PostponeCardsCommand extends AbstractPostponeCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(PostponeCardsCommand.class);

	public PostponeCardsCommand(PostponeCardsData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(this.getHandle(), this.commandData.getBoxId());
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwUnauthorized();
		}
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
