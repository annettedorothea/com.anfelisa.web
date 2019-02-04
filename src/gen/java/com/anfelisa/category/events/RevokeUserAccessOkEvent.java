package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.IRevokeUserData;

public class RevokeUserAccessOkEvent extends Event<IRevokeUserData> {

	public RevokeUserAccessOkEvent(IRevokeUserData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.RevokeUserAccessOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
