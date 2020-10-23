/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.box.data.IBoxUpdateData;

public abstract class AbstractUpdateBoxCommand extends Command<IBoxUpdateData> {

	protected static final String ok = "ok";

	public AbstractUpdateBoxCommand(IBoxUpdateData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.UpdateBoxCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.UpdateBoxOkEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
			break;
		default:
			throw new RuntimeException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}




/******* S.D.G. *******/



