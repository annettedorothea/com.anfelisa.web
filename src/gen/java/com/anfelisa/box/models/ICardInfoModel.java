package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardInfoModel.class)
public interface ICardInfoModel {

	String getCardId();
	String getCardOfBoxId();
	String getContent();
	String getBoxName();
	Integer getCount();
	org.joda.time.DateTime getLast();
	org.joda.time.DateTime getNext();
	Integer getQuality();

}

/*       S.D.G.       */
