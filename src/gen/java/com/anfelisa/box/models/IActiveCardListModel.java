/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ActiveCardListModel.class)
public interface IActiveCardListModel {

	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> getCardList();
	void setCardList(java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList);
	
	Boolean getEditable();
	void setEditable(Boolean editable);
	
	
}




/******* S.D.G. *******/



