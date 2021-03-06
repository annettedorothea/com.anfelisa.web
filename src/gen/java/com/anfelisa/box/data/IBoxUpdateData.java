/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxUpdateModel;

@JsonDeserialize(as=BoxUpdateData.class)
public interface IBoxUpdateData extends IBoxUpdateModel, IDataContainer {
	
	IBoxUpdateData withUserId(String userId);
	
	IBoxUpdateData withBoxId(String boxId);
	
	IBoxUpdateData withMaxInterval(Integer maxInterval);
	
	IBoxUpdateData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	IBoxUpdateData withCategoryName(String categoryName);
	
	IBoxUpdateData withDictionaryLookup(Boolean dictionaryLookup);
	
	IBoxUpdateData withGivenLanguage(String givenLanguage);
	
	IBoxUpdateData withWantedLanguage(String wantedLanguage);
	
	IBoxUpdateData withCategoryId(String categoryId);
	
	
}



/******* S.D.G. *******/



