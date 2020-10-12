/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryUpdateModel;

@JsonDeserialize(as=CategoryUpdateData.class)
public interface ICategoryUpdateData extends ICategoryUpdateModel, IDataContainer {
	
	ICategoryUpdateData withCategoryId(String categoryId);
	
	ICategoryUpdateData withCategoryName(String categoryName);
	
	ICategoryUpdateData withUserId(String userId);
	
	
}



/******* S.D.G. *******/



