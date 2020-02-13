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

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InitMyBoxesDataModel implements IInitMyBoxesDataModel {

	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	
	private java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards;
	
	private java.util.List<String> outdatedReinforceCardsIds;
	

	public InitMyBoxesDataModel() {
	}

	public InitMyBoxesDataModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today,
		@JsonProperty("postponeCards") java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards,
		@JsonProperty("outdatedReinforceCardsIds") java.util.List<String> outdatedReinforceCardsIds
	) {
		this.userId = userId;
		this.today = today;
		this.postponeCards = postponeCards;
		this.outdatedReinforceCardsIds = outdatedReinforceCardsIds;
	}

	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
		public org.joda.time.DateTime getToday() {
			return this.today;
		}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	
	@JsonProperty
		public java.util.List<com.anfelisa.box.models.IPostponeCardsModel> getPostponeCards() {
			return this.postponeCards;
		}
	public void setPostponeCards(java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards) {
		this.postponeCards = postponeCards;
	}
	
	@JsonProperty
		public java.util.List<String> getOutdatedReinforceCardsIds() {
			return this.outdatedReinforceCardsIds;
		}
	public void setOutdatedReinforceCardsIds(java.util.List<String> outdatedReinforceCardsIds) {
		this.outdatedReinforceCardsIds = outdatedReinforceCardsIds;
	}
	
	
}




/******* S.D.G. *******/


