package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.UserUpdateData;

public abstract class AbstractUpdateUserCommand extends Command<UserUpdateData> {

	protected static final String success = "success";

	public AbstractUpdateUserCommand(UserUpdateData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.UpdateUserCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case success:
			new com.anfelisa.user.events.UserUpdatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
