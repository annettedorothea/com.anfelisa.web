/********************************************************************************
 * generated by de.acegen 1.0.2
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class UpdateCardPayload implements IUpdateCardPayload {
	
	private String cardId;
	
	private String given;
	
	private String image;
	
	private String wanted;
	
	public UpdateCardPayload() {
	}
	
	public UpdateCardPayload(com.anfelisa.card.models.ICardUpdateModel data) {
		cardId = data.getCardId();
		given = data.getGiven();
		image = data.getImage();
		wanted = data.getWanted();
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	
}



/******* S.D.G. *******/



