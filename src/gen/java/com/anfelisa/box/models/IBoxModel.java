package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxModel.class)
public interface IBoxModel {

	String getBoxId();
	void setBoxId(String boxId);
	
	String getUserId();
	void setUserId(String userId);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	Integer getMaxInterval();
	void setMaxInterval(Integer maxInterval);
	
	Integer getMaxCardsPerDay();
	void setMaxCardsPerDay(Integer maxCardsPerDay);
	
	
	List<String> equalsPrimitiveTypes(IBoxModel other);
	
}

/*       S.D.G.       */
