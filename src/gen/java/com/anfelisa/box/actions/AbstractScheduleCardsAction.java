/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.actions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.HttpMethod;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ITimelineItem;
import de.acegen.ViewProvider;
import de.acegen.NonDeterministicDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.box.data.IScheduledCardsData;
import com.anfelisa.box.data.ScheduledCardsData;
import com.anfelisa.box.commands.ScheduleCardsCommand;

@SuppressWarnings("unused")
public abstract class AbstractScheduleCardsAction extends WriteAction<IScheduledCardsData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractScheduleCardsAction.class);
	
	public AbstractScheduleCardsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.ScheduleCardsAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new ScheduleCardsCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected void initActionDataFromNonDeterministicDataProvider() {
		LocalDateTime systemTime = NonDeterministicDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		}
	}

}




/******* S.D.G. *******/



