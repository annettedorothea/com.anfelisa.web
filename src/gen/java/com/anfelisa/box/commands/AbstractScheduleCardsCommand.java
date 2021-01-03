/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.box.data.IScheduledCardsData;

public abstract class AbstractScheduleCardsCommand extends Command<IScheduledCardsData> {

	public AbstractScheduleCardsCommand(IScheduledCardsData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScheduleCardsCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome() {
		this.commandData.addOutcome("ok");
	}

	protected void addNullOrEmptyOutcome() {
		this.commandData.addOutcome("nullOrEmpty");
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (this.commandData.hasOutcome("ok")){
			new com.anfelisa.box.events.ScheduleCardsOkEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



