package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;
import com.anfelisa.box.models.ICardQualityModel;

@SuppressWarnings("unused")
public class ScoreCardData implements IScoreCardData {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer cardId;
	
	@NotEmpty
	private String content;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private String contentHash;
	
	@NotNull
	private Integer maxPoints;
	
	@NotNull
	private Integer cardOfBoxId;
	
	private Float ef;
	
	private Integer interval;
	
	private Integer n;
	
	@NotNull
	private Integer count;
	
	private org.joda.time.DateTime date;
	
	@NotNull
	private Integer boxId;
	
	private Integer quality;
	
	private org.joda.time.DateTime timestamp;
	
	private Integer points;
	
	@NotNull
	private Integer submittedQuality;
	

	
	
	

	public ScoreCardData(
		@JsonProperty("cardId") Integer cardId,
		@JsonProperty("content") String content,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("contentHash") String contentHash,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("cardOfBoxId") Integer cardOfBoxId,
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("n") Integer n,
		@JsonProperty("count") Integer count,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp,
		@JsonProperty("points") Integer points,
		@JsonProperty("submittedQuality") Integer submittedQuality
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.cardId = cardId;
		this.content = content;
		this.testId = testId;
		this.contentHash = contentHash;
		this.maxPoints = maxPoints;
		this.cardOfBoxId = cardOfBoxId;
		this.ef = ef;
		this.interval = interval;
		this.n = n;
		this.count = count;
		this.date = date;
		this.boxId = boxId;
		this.quality = quality;
		this.timestamp = timestamp;
		this.points = points;
		this.submittedQuality = submittedQuality;
		this.uuid = uuid;
		this.schema = schema;
	}

	public ScoreCardData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getCardId() {
		return this.cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public ScoreCardData withCardId(Integer cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ScoreCardData withContent(String content) {
		this.content = content;
		return this;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public ScoreCardData withTestId(Integer testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public String getContentHash() {
		return this.contentHash;
	}
	public void setContentHash(String contentHash) {
		this.contentHash = contentHash;
	}
	public ScoreCardData withContentHash(String contentHash) {
		this.contentHash = contentHash;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxPoints() {
		return this.maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	public ScoreCardData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
	@JsonProperty
	public Integer getCardOfBoxId() {
		return this.cardOfBoxId;
	}
	public void setCardOfBoxId(Integer cardOfBoxId) {
		this.cardOfBoxId = cardOfBoxId;
	}
	public ScoreCardData withCardOfBoxId(Integer cardOfBoxId) {
		this.cardOfBoxId = cardOfBoxId;
		return this;
	}
	
	@JsonProperty
	public Float getEf() {
		return this.ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	public ScoreCardData withEf(Float ef) {
		this.ef = ef;
		return this;
	}
	
	@JsonProperty
	public Integer getInterval() {
		return this.interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	public ScoreCardData withInterval(Integer interval) {
		this.interval = interval;
		return this;
	}
	
	@JsonProperty
	public Integer getN() {
		return this.n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public ScoreCardData withN(Integer n) {
		this.n = n;
		return this;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public ScoreCardData withCount(Integer count) {
		this.count = count;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
	}
	public ScoreCardData withDate(org.joda.time.DateTime date) {
		this.date = date;
		return this;
	}
	
	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public ScoreCardData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public ScoreCardData withQuality(Integer quality) {
		this.quality = quality;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
	}
	public ScoreCardData withTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public ScoreCardData withPoints(Integer points) {
		this.points = points;
		return this;
	}
	
	@JsonProperty
	public Integer getSubmittedQuality() {
		return this.submittedQuality;
	}
	public void setSubmittedQuality(Integer submittedQuality) {
		this.submittedQuality = submittedQuality;
	}
	public ScoreCardData withSubmittedQuality(Integer submittedQuality) {
		this.submittedQuality = submittedQuality;
		return this;
	}
	
	
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */