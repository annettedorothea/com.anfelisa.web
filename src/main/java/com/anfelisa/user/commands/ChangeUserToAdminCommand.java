package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.ChangeUserRoleData;

public class ChangeUserToAdminCommand extends AbstractChangeUserToAdminCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserToAdminCommand.class);

	public ChangeUserToAdminCommand(ChangeUserRoleData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = ok;
	}

}

/*       S.D.G.       */