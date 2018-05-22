package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardUpdateModel;

@SuppressWarnings("all")
public class CardUpdatePresentationalData implements ICardUpdatePresentationalData {
	
	@NotNull
	private String cardId;
	
	@NotEmpty
	private String given;
	
	@NotEmpty
	private String wanted;
	
	private String image;
	
	@NotNull
	private Integer cardIndex;
	
	
	public CardUpdatePresentationalData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("cardIndex") Integer cardIndex
	) {
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.cardIndex = cardIndex;
		
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardUpdatePresentationalData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public CardUpdatePresentationalData withGiven(String given) {
		this.given = given;
		return this;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	public CardUpdatePresentationalData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CardUpdatePresentationalData withImage(String image) {
		this.image = image;
		return this;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	public CardUpdatePresentationalData withCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
		return this;
	}
	
}

/*       S.D.G.       */
