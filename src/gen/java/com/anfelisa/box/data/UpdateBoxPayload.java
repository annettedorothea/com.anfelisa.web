/********************************************************************************
 * generated by de.acegen 1.0.1
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
public class UpdateBoxPayload implements IUpdateBoxPayload {
	
	private Integer maxInterval;
	
	private Integer maxCardsPerDay;
	
	private String boxId;
	
	private String categoryId;
	
	private String categoryName;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	public UpdateBoxPayload() {
	}
	
	public UpdateBoxPayload(com.anfelisa.box.models.IBoxUpdateModel data) {
		maxInterval = data.getMaxInterval();
		maxCardsPerDay = data.getMaxCardsPerDay();
		boxId = data.getBoxId();
		categoryId = data.getCategoryId();
		categoryName = data.getCategoryName();
		dictionaryLookup = data.getDictionaryLookup();
		givenLanguage = data.getGivenLanguage();
		wantedLanguage = data.getWantedLanguage();
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
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
	
}



/******* S.D.G. *******/


