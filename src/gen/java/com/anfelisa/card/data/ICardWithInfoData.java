/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardWithInfoModel;

@JsonDeserialize(as=CardWithInfoData.class)
public interface ICardWithInfoData extends ICardWithInfoModel, IDataContainer {
	void mapFrom(com.anfelisa.card.models.ICardModel model);
	
	ICardWithInfoData withNext(java.time.LocalDateTime next);
	
	ICardWithInfoData withCardId(String cardId);
	
	ICardWithInfoData withGiven(String given);
	
	ICardWithInfoData withWanted(String wanted);
	
	ICardWithInfoData withImage(String image);
	
	ICardWithInfoData withCardAuthor(String cardAuthor);
	
	ICardWithInfoData withCardIndex(Integer cardIndex);
	
	ICardWithInfoData withCategoryId(String categoryId);
	
	ICardWithInfoData withRootCategoryId(String rootCategoryId);
	
	ICardWithInfoData withPriority(Integer priority);
	
	
}



/******* S.D.G. *******/



