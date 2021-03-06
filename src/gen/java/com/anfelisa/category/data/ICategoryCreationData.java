/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryCreationModel;

@JsonDeserialize(as=CategoryCreationData.class)
public interface ICategoryCreationData extends ICategoryCreationModel, IDataContainer {
	void mapFrom(com.anfelisa.category.models.ICategoryModel model);
	
	ICategoryCreationData withUsername(String username);
	
	ICategoryCreationData withUserId(String userId);
	
	ICategoryCreationData withCategoryId(String categoryId);
	
	ICategoryCreationData withCategoryName(String categoryName);
	
	ICategoryCreationData withCategoryAuthor(String categoryAuthor);
	
	ICategoryCreationData withCategoryIndex(Integer categoryIndex);
	
	ICategoryCreationData withParentCategoryId(String parentCategoryId);
	
	ICategoryCreationData withRootCategoryId(String rootCategoryId);
	
	ICategoryCreationData withDictionaryLookup(Boolean dictionaryLookup);
	
	ICategoryCreationData withGivenLanguage(String givenLanguage);
	
	ICategoryCreationData withWantedLanguage(String wantedLanguage);
	
	
}



/******* S.D.G. *******/



