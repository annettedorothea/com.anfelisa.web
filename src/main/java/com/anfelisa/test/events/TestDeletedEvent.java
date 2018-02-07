package com.anfelisa.test.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestIdData;

public class TestDeletedEvent extends AbstractTestDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(TestDeletedEvent.class);

	public TestDeletedEvent(TestIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public TestDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
