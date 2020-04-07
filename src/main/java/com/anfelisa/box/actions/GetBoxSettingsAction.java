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

package com.anfelisa.box.actions;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IBoxSettingsModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetBoxSettingsAction extends AbstractGetBoxSettingsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxSettingsAction.class);

	public GetBoxSettingsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider,
			ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
	}

	protected void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		if (this.actionData.getBoxId() == null || "null".equals(this.actionData.getBoxId())) {
			throwBadRequest("box id must not be null");
		}
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, this.actionData.getBoxId());
		if (!box.getUserId().equals(actionData.getUserId())) {
			throwUnauthorized();
		}
		IBoxSettingsModel settings = this.daoProvider.getBoxDao().selectSettingsByBoxId(readonlyHandle,
				actionData.getBoxId());
		this.actionData.setMaxCardsPerDay(settings.getMaxCardsPerDay());
		this.actionData.setMaxInterval(settings.getMaxInterval());
		this.actionData.setCategoryId(settings.getCategoryId());
		this.actionData.setCategoryName(settings.getCategoryName());
		this.actionData.setDictionaryLookup(settings.getDictionaryLookup());
		this.actionData.setGivenLanguage(settings.getGivenLanguage());
		this.actionData.setWantedLanguage(settings.getWantedLanguage());
	}

	public void initActionData() {
	}

}

/******* S.D.G. *******/
