package com.anfelisa.test.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.CardContentHashListData;


public abstract class AbstractGetCardsOfTestAction extends Action<CardContentHashListData> {

	public AbstractGetCardsOfTestAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.test.actions.GetCardsOfTestAction", HttpMethod.GET, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CardContentHashListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
