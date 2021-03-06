/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.box.data.IScoreCardData;

public abstract class AbstractScoreCardCommand extends Command<IScoreCardData> {

	public AbstractScoreCardCommand(IScoreCardData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScoreCardCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	protected void addScoreOutcome() {
		this.commandData.addOutcome("score");
	}

	protected void addReinforceOutcome() {
		this.commandData.addOutcome("reinforce");
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (this.commandData.hasOutcome("score")){
			new com.anfelisa.box.events.ScoreCardScoreEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
		}
		if (this.commandData.hasOutcome("reinforce")){
			new com.anfelisa.box.events.ScoreCardReinforceEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



