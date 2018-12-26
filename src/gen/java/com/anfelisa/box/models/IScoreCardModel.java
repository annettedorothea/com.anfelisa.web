package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoreCardModel.class)
public interface IScoreCardModel {

	String getCardId();
	String getNextScheduledCardScheduledCardId();
	org.joda.time.DateTime getNextScheduledCardCreatedDate();
	Float getNextScheduledCardEf();
	Integer getNextScheduledCardInterval();
	Integer getNextScheduledCardN();
	Integer getNextScheduledCardCount();
	org.joda.time.DateTime getNextScheduledCardScheduledDate();
	Integer getNextScheduledCardLastQuality();
	String getScoredCardScheduledCardId();
	Integer getScoredCardQuality();
	org.joda.time.DateTime getScoredCardScoredDate();
	String getReinforceCardId();
	org.joda.time.DateTime getReinforceCardCreatedDate();

}

/*       S.D.G.       */
