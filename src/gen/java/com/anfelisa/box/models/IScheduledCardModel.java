package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduledCardModel.class)
public interface IScheduledCardModel {

	String getScheduledCardId();
	String getCardId();
	Float getEf();
	Integer getInterval();
	Integer getN();
	Integer getCount();
	org.joda.time.DateTime getScheduledDate();
	String getBoxId();
	Integer getLastQuality();
	org.joda.time.DateTime getTimestamp();
	Boolean getRemoved();

}

/*       S.D.G.       */
