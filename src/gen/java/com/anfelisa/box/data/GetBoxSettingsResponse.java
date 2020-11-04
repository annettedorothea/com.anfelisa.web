/********************************************************************************
 * generated by de.acegen 1.0.2
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
public class GetBoxSettingsResponse implements IGetBoxSettingsResponse {
	
	private Integer maxCardsPerDay;
	
	private Integer maxInterval;
	
	private String categoryName;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	private String categoryId;
	
	private Integer allCards;
	
	private Integer allActiveCards;
	
	public GetBoxSettingsResponse() {
	}
	
	public GetBoxSettingsResponse(com.anfelisa.box.models.IBoxSettingsWrapperModel data) {
		maxCardsPerDay = data.getMaxCardsPerDay();
		maxInterval = data.getMaxInterval();
		categoryName = data.getCategoryName();
		dictionaryLookup = data.getDictionaryLookup();
		givenLanguage = data.getGivenLanguage();
		wantedLanguage = data.getWantedLanguage();
		categoryId = data.getCategoryId();
		allCards = data.getAllCards();
		allActiveCards = data.getAllActiveCards();
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	
	@JsonProperty
	public Boolean getDictionaryLookup() {
		return this.dictionaryLookup;
	}
	
	@JsonProperty
	public String getGivenLanguage() {
		return this.givenLanguage;
	}
	
	@JsonProperty
	public String getWantedLanguage() {
		return this.wantedLanguage;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
	@JsonProperty
	public Integer getAllCards() {
		return this.allCards;
	}
	
	@JsonProperty
	public Integer getAllActiveCards() {
		return this.allActiveCards;
	}
	
}



/******* S.D.G. *******/



