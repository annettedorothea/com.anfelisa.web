/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeModel;

@JsonDeserialize(as=CategoryTreeData.class)
public interface ICategoryTreeData extends ICategoryTreeModel, IDataContainer {
	
	ICategoryTreeData withRootCategory(com.anfelisa.category.models.ICategoryTreeItemModel rootCategory);
	
	ICategoryTreeData withUserId(String userId);
	
	ICategoryTreeData withRootCategoryId(String rootCategoryId);
	
	
}



/******* S.D.G. *******/



