/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxViewModel;

@JsonDeserialize(as=BoxViewData.class)
public interface IBoxViewData extends IBoxViewModel, IDataContainer {
	
	IBoxViewData withOpenTodaysCards(Integer openTodaysCards);
	
	IBoxViewData withCategoryName(String categoryName);
	
	IBoxViewData withCategoryId(String categoryId);
	
	IBoxViewData withBoxId(String boxId);
	
	IBoxViewData withReverse(Boolean reverse);
	
	
}



/******* S.D.G. *******/



