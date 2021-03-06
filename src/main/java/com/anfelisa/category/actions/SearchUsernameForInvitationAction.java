/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.actions;

import de.acegen.CustomAppConfiguration;
import de.acegen.ViewProvider;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class SearchUsernameForInvitationAction extends AbstractSearchUsernameForInvitationAction {

	static final Logger LOG = LoggerFactory.getLogger(SearchUsernameForInvitationAction.class);

	public SearchUsernameForInvitationAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
			ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}


	@Override
	protected void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		IUserAccessToCategoryModel access = daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle, actionData.getCategoryId(), actionData.getUserId());
		if (access == null || !access.getEditable()) {
			throwSecurityException();
		}
		List<String> usernames = daoProvider.getCategoryDao().search(readonlyHandle, actionData.getUsernameSearchString(), actionData.getCategoryId());
		this.actionData.setUsernames(usernames);
	}
	
	public void initActionData() {
	}

}




/******* S.D.G. *******/



