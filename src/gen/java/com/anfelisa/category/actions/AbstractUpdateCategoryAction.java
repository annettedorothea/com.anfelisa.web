/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.category.actions;

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

import com.anfelisa.category.data.ICategoryUpdateData;
import com.anfelisa.category.data.CategoryUpdateData;
import com.anfelisa.category.commands.UpdateCategoryCommand;

@SuppressWarnings("unused")
public abstract class AbstractUpdateCategoryAction extends WriteAction<ICategoryUpdateData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUpdateCategoryAction.class);
	
	public AbstractUpdateCategoryAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.UpdateCategoryAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateCategoryCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
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



