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




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=InitMyBoxesDataModel.class)
public interface IInitMyBoxesDataModel {

	String getUserId();
	void setUserId(String userId);
	
	org.joda.time.DateTime getToday();
	void setToday(org.joda.time.DateTime today);
	
	java.util.List<com.anfelisa.box.models.IPostponeCardsModel> getPostponeCards();
	void setPostponeCards(java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards);
	
	java.util.List<String> getOutdatedReinforceCardsIds();
	void setOutdatedReinforceCardsIds(java.util.List<String> outdatedReinforceCardsIds);
	
	
}




/******* S.D.G. *******/


