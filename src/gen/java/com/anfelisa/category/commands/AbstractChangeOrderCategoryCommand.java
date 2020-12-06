/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.category.data.ICategoryChangeOrderData;

public abstract class AbstractChangeOrderCategoryCommand extends Command<ICategoryChangeOrderData> {

	public AbstractChangeOrderCategoryCommand(ICategoryChangeOrderData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.ChangeOrderCategoryCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome() {
		this.commandData.addOutcome("ok");
	}

	protected void addNoMoveOutcome() {
		this.commandData.addOutcome("noMove");
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (this.commandData.hasOutcome("ok")){
			new com.anfelisa.category.events.ChangeOrderCategoryOkEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



