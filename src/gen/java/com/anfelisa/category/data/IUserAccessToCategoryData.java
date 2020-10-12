/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.IUserAccessToCategoryModel;

@JsonDeserialize(as=UserAccessToCategoryData.class)
public interface IUserAccessToCategoryData extends IUserAccessToCategoryModel, IDataContainer {
	
	IUserAccessToCategoryData withCategoryId(String categoryId);
	
	IUserAccessToCategoryData withUserId(String userId);
	
	IUserAccessToCategoryData withEditable(Boolean editable);
	
	
}



/******* S.D.G. *******/



