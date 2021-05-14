/********************************************************************************
 * generated by de.acegen 1.2.1
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
public class ScoreCardPayload implements IScoreCardPayload {
	
	private String scheduledCardId;
	
	private Integer scoredCardQuality;
	
	public ScoreCardPayload() {
	}
	
	public ScoreCardPayload(com.anfelisa.box.models.IScoreCardModel data) {
		scheduledCardId = data.getScheduledCardId();
		scoredCardQuality = data.getScoredCardQuality();
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	
	@JsonProperty
	public Integer getScoredCardQuality() {
		return this.scoredCardQuality;
	}
	
}



/******* S.D.G. *******/



