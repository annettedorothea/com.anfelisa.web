/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxListModel.class)
public interface IBoxListModel {

	java.util.List<com.anfelisa.box.models.IBoxViewModel> getBoxList();
	void setBoxList(java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList);
	
	String getUserId();
	void setUserId(String userId);
	
	java.time.LocalDateTime getTodayAtMidnightInUTC();
	void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC);
	
	
}




/******* S.D.G. *******/



