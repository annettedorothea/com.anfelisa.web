package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.PasswordUpdateData;

public class UpdatePasswordCommand extends AbstractUpdatePasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdatePasswordCommand.class);

	public UpdatePasswordCommand(PasswordUpdateData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = success;
	}

}

/*       S.D.G.       */
