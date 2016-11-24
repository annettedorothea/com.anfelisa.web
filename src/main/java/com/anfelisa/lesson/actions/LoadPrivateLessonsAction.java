package com.anfelisa.lesson.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonListData;

public class LoadPrivateLessonsAction extends AbstractLoadPrivateLessonsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateLessonsAction.class);

	public LoadPrivateLessonsAction(LessonListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
	}

}

/*       S.D.G.       */
