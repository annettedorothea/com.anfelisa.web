/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.card.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.card.data.ICardUpdatePriorityData;

public abstract class AbstractUpdateCardPriorityCommand extends Command<ICardUpdatePriorityData> {

	protected static final String ok = "ok";

	public AbstractUpdateCardPriorityCommand(ICardUpdatePriorityData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.UpdateCardPriorityCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.card.events.UpdateCardPriorityOkEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
			break;
		default:
			throw new RuntimeException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}




/******* S.D.G. *******/



