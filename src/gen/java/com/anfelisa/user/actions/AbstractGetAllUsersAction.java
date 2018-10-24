package com.anfelisa.user.actions;

import org.jdbi.v3.core.Jdbi;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UserListData;


public abstract class AbstractGetAllUsersAction extends Action<UserListData> {

	public AbstractGetAllUsersAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.GetAllUsersAction", HttpMethod.GET, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, UserListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
