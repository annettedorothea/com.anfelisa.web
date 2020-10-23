/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.box.data;

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
public class SortCardsOutPayload implements ISortCardsOutPayload {
	
	private java.util.List<String> cardIds;
	
	public SortCardsOutPayload() {
	}
	
	public SortCardsOutPayload(com.anfelisa.box.models.ISortCardsOutModel data) {
		cardIds = data.getCardIds();
	}
	
	@JsonProperty
	public java.util.List<String> getCardIds() {
		return this.cardIds;
	}
	
}



/******* S.D.G. *******/



