package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.ScoredCardData;

import com.anfelisa.box.commands.CreateScoredCardCommand;

public abstract class AbstractCreateScoredCardAction extends Action<ScoredCardData> {

	public AbstractCreateScoredCardAction(DBI jdbi) {
		super("CreateScoredCardAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateScoredCardCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

	protected void throwBadRequest() {
		throw new WebApplicationException(Response.Status.BAD_REQUEST);
	}

}

/*       S.D.G.       */