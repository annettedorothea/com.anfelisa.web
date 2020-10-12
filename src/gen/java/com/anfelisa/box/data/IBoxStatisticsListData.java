/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxStatisticsListModel;

@JsonDeserialize(as=BoxStatisticsListData.class)
public interface IBoxStatisticsListData extends IBoxStatisticsListModel, IDataContainer {
	
	IBoxStatisticsListData withBoxStatisticsList(java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsList);
	
	IBoxStatisticsListData withUserId(String userId);
	
	IBoxStatisticsListData withTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC);
	
	
}



/******* S.D.G. *******/



