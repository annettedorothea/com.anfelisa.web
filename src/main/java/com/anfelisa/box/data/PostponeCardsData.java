package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostponeCardsData extends AbstractData implements IPostponeCardsData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public PostponeCardsData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.userId = userId;
		this.today = today;
	}

	public PostponeCardsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public PostponeCardsData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public PostponeCardsData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public PostponeCardsData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new PostponeCardsPresentationalData(
			this.boxId,
			this.userId,
			this.today
		);
	}

}

/*       S.D.G.       */