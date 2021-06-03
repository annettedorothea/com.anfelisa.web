/********************************************************************************
 * generated by de.acegen 1.2.1
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

import com.anfelisa.category.data.ICategoryMoveData;
import com.anfelisa.category.data.CategoryMoveData;
import com.anfelisa.category.commands.MoveCategoryCommand;

@SuppressWarnings("unused")
public abstract class AbstractMoveCategoryAction extends WriteAction<ICategoryMoveData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractMoveCategoryAction.class);
	
	public AbstractMoveCategoryAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.MoveCategoryAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand<ICategoryMoveData> getCommand() {
		return new MoveCategoryCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected ICategoryMoveData initActionDataFromNonDeterministicDataProvider(ICategoryMoveData data) {
		LocalDateTime systemTime = NonDeterministicDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public ICategoryMoveData initActionData(ICategoryMoveData data) {
		return data;
	}

}




/******* S.D.G. *******/



