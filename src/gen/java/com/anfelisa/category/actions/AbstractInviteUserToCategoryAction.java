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

import com.anfelisa.category.data.IUserToCategoryInvitationData;
import com.anfelisa.category.data.UserToCategoryInvitationData;
import com.anfelisa.category.commands.InviteUserToCategoryCommand;

@SuppressWarnings("unused")
public abstract class AbstractInviteUserToCategoryAction extends WriteAction<IUserToCategoryInvitationData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractInviteUserToCategoryAction.class);
	
	public AbstractInviteUserToCategoryAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.InviteUserToCategoryAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand<IUserToCategoryInvitationData> getCommand() {
		return new InviteUserToCategoryCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected IUserToCategoryInvitationData initActionDataFromNonDeterministicDataProvider(IUserToCategoryInvitationData data) {
		LocalDateTime systemTime = NonDeterministicDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IUserToCategoryInvitationData initActionData(IUserToCategoryInvitationData data) {
		return data;
	}

}




/******* S.D.G. *******/



