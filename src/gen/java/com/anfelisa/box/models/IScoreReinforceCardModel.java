/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ScoreReinforceCardModel.class)
public interface IScoreReinforceCardModel {

	String getReinforceCardId();
	void setReinforceCardId(String reinforceCardId);
	
	Integer getScoredCardQuality();
	void setScoredCardQuality(Integer scoredCardQuality);
	
	java.time.LocalDateTime getChangeDate();
	void setChangeDate(java.time.LocalDateTime changeDate);
	
	String getUserId();
	void setUserId(String userId);
	
	
}




/******* S.D.G. *******/



