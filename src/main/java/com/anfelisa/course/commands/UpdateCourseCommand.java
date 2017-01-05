package com.anfelisa.course.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseData;

public class UpdateCourseCommand extends AbstractUpdateCourseCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCourseCommand.class);

	public UpdateCourseCommand(CourseData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = updated;
	}

}

/*       S.D.G.       */