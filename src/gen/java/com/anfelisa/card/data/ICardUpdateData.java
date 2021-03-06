/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardUpdateModel;

@JsonDeserialize(as=CardUpdateData.class)
public interface ICardUpdateData extends ICardUpdateModel, IDataContainer {
	
	ICardUpdateData withCardId(String cardId);
	
	ICardUpdateData withGiven(String given);
	
	ICardUpdateData withWanted(String wanted);
	
	ICardUpdateData withImage(String image);
	
	ICardUpdateData withUserId(String userId);
	
	
}



/******* S.D.G. *******/



