/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=NextCardViewModel.class)
public interface INextCardViewModel {

	String getScheduledCardId();
	void setScheduledCardId(String scheduledCardId);
	
	String getReinforceCardId();
	void setReinforceCardId(String reinforceCardId);
	
	String getCardId();
	void setCardId(String cardId);
	
	java.time.LocalDateTime getScheduledDate();
	void setScheduledDate(java.time.LocalDateTime scheduledDate);
	
	Integer getLastQuality();
	void setLastQuality(Integer lastQuality);
	
	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getImage();
	void setImage(String image);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	Integer getCount();
	void setCount(Integer count);
	
	java.time.LocalDateTime getScoredDate();
	void setScoredDate(java.time.LocalDateTime scoredDate);
	
	
}




/******* S.D.G. *******/



