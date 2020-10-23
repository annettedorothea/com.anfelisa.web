/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.ITodaysCardsStatusModel;

@JsonDeserialize(as=TodaysCardsStatusData.class)
public interface ITodaysCardsStatusData extends ITodaysCardsStatusModel, IDataContainer {
	
	ITodaysCardsStatusData withOpenTodaysCards(Integer openTodaysCards);
	
	ITodaysCardsStatusData withAllTodaysCards(Integer allTodaysCards);
	
	
}



/******* S.D.G. *******/



