/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.card.actions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.HttpMethod;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ITimelineItem;
import de.acegen.ViewProvider;
import de.acegen.NotReplayableDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.card.commands.CreateCardCommand;

@SuppressWarnings("unused")
public abstract class AbstractCreateCardAction extends WriteAction<ICardCreationData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateCardAction.class);
	
	public AbstractCreateCardAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.card.actions.CreateCardAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCardCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected void initActionDataFrom(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		ICardCreationData originalActionData = (ICardCreationData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
	}


	@Override
	protected void initActionDataFromNotReplayableDataProvider() {
		LocalDateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		} else {
			this.actionData.setSystemTime(LocalDateTime.now());
		}
	}

}




/******* S.D.G. *******/



