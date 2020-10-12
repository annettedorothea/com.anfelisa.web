/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxSettingsWrapperModel;

@JsonDeserialize(as=BoxSettingsWrapperData.class)
public interface IBoxSettingsWrapperData extends IBoxSettingsWrapperModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.IBoxSettingsModel model);
	
	IBoxSettingsWrapperData withUserId(String userId);
	
	IBoxSettingsWrapperData withBoxId(String boxId);
	
	IBoxSettingsWrapperData withMaxInterval(Integer maxInterval);
	
	IBoxSettingsWrapperData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	IBoxSettingsWrapperData withCategoryName(String categoryName);
	
	IBoxSettingsWrapperData withDictionaryLookup(Boolean dictionaryLookup);
	
	IBoxSettingsWrapperData withGivenLanguage(String givenLanguage);
	
	IBoxSettingsWrapperData withWantedLanguage(String wantedLanguage);
	
	IBoxSettingsWrapperData withCategoryId(String categoryId);
	
	
}



/******* S.D.G. *******/



