package com.anfelisa.card.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDeleteData extends AbstractData implements ICardDeleteData {
	
	@NotNull
	private String cardId;
	
	@NotNull
	private Integer cardIndex;
	
	@NotNull
	private String categoryId;
	

	public CardDeleteData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardId = cardId;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
	}

	public CardDeleteData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardDeleteData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	public CardDeleteData withCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CardDeleteData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CardDeletePresentationalData(
			this.cardId,
			this.cardIndex,
			this.categoryId
		);
	}

}

/*       S.D.G.       */