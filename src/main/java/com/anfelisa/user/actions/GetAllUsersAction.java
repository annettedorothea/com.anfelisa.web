package com.anfelisa.user.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.Roles;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetAllUsersAction extends AbstractGetAllUsersAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllUsersAction.class);

	public GetAllUsersAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		if (!Roles.ADMIN.equals(this.actionData.getRole())) {
			throwSecurityException();
		}
		List<IUserModel> users = daoProvider.getUserDao().selectAll(readonlyHandle);
		this.actionData.setUserList(users);
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
