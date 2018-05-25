package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.BoxUpdateData;

public class UpdateBoxOkEvent extends AbstractUpdateBoxOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxOkEvent.class);

	public UpdateBoxOkEvent(BoxUpdateData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(eventParam, databaseHandle, daoProvider, viewProvider);
	}

	public UpdateBoxOkEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		this(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
