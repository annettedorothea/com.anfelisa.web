package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryMoveModel.class)
public interface ICategoryMoveModel {

	String getMovedCategoryId();
	void setMovedCategoryId(String movedCategoryId);
	
	String getTargetCategoryId();
	void setTargetCategoryId(String targetCategoryId);
	
	com.anfelisa.category.models.ICategoryModel getMovedCategory();
	void setMovedCategory(com.anfelisa.category.models.ICategoryModel movedCategory);
	
	String getUserId();
	void setUserId(String userId);
	

}

/*       S.D.G.       */
