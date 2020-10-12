/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxStatisticsModel.class)
public interface IBoxStatisticsModel {

	String getBoxId();
	void setBoxId(String boxId);
	
	Integer getQuality0Count();
	void setQuality0Count(Integer quality0Count);
	
	Integer getQuality1Count();
	void setQuality1Count(Integer quality1Count);
	
	Integer getQuality2Count();
	void setQuality2Count(Integer quality2Count);
	
	Integer getQuality3Count();
	void setQuality3Count(Integer quality3Count);
	
	Integer getQuality4Count();
	void setQuality4Count(Integer quality4Count);
	
	Integer getQuality5Count();
	void setQuality5Count(Integer quality5Count);
	
	java.util.List<Integer> getCountsPerDayNextWeek();
	void setCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek);
	
	Integer getMaxCardsPerDay();
	void setMaxCardsPerDay(Integer maxCardsPerDay);
	
	
}




/******* S.D.G. *******/



