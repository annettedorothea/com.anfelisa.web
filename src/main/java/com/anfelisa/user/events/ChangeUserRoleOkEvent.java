package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ChangeUserRoleData;

public class ChangeUserRoleOkEvent extends AbstractChangeUserRoleOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleOkEvent.class);

	public ChangeUserRoleOkEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ChangeUserRoleOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
