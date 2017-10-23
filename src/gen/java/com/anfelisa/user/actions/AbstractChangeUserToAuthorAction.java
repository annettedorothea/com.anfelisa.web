package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.ChangeUserRoleData;

import com.anfelisa.user.commands.ChangeUserToAuthorCommand;

public abstract class AbstractChangeUserToAuthorAction extends Action<ChangeUserRoleData> {

	public AbstractChangeUserToAuthorAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.user.actions.ChangeUserToAuthorAction", HttpMethod.PUT, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new ChangeUserToAuthorCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, ChangeUserRoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */