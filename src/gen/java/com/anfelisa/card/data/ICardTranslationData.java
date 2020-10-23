/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardTranslationModel;

@JsonDeserialize(as=CardTranslationData.class)
public interface ICardTranslationData extends ICardTranslationModel, IDataContainer {
	
	ICardTranslationData withSourceValue(String sourceValue);
	
	ICardTranslationData withTargetValue(String targetValue);
	
	ICardTranslationData withSourceLanguage(String sourceLanguage);
	
	ICardTranslationData withTargetLanguage(String targetLanguage);
	
	
}



/******* S.D.G. *******/



