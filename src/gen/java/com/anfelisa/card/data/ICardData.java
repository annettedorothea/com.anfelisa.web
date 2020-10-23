/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardModel;

@JsonDeserialize(as=CardData.class)
public interface ICardData extends ICardModel, IDataContainer {
	
	ICardData withCardId(String cardId);
	
	ICardData withGiven(String given);
	
	ICardData withWanted(String wanted);
	
	ICardData withImage(String image);
	
	ICardData withCardAuthor(String cardAuthor);
	
	ICardData withCardIndex(Integer cardIndex);
	
	ICardData withCategoryId(String categoryId);
	
	ICardData withRootCategoryId(String rootCategoryId);
	
	ICardData withPriority(Integer priority);
	
	
}



/******* S.D.G. *******/



