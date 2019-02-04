package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScoreCardData;

public class ScoreCardScoreAndReinforceEvent extends Event<IScoreCardData> {

	public ScoreCardScoreAndReinforceEvent(IScoreCardData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
