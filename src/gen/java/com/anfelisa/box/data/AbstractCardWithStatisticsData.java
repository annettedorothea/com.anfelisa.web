/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.ICardWithStatisticsModel;
import com.anfelisa.card.models.ICardWithInfoModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractCardWithStatisticsData extends AbstractData implements ICardWithStatisticsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardWithStatisticsData.class);
	
	private Float ef;
	
	private Integer interval;
	
	private Integer count;
	
	private Integer lastQuality;
	
	private java.time.LocalDateTime next;
	
	private String cardId;
	
	private String given;
	
	private String wanted;
	
	private String cardAuthor;
	
	private Integer cardIndex;
	
	private String categoryId;
	
	private String rootCategoryId;
	
	private Integer priority;
	

	public AbstractCardWithStatisticsData(
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("count") Integer count,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("next") java.time.LocalDateTime next,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("priority") Integer priority
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.ef = ef;
		this.interval = interval;
		this.count = count;
		this.lastQuality = lastQuality;
		this.next = next;
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.cardAuthor = cardAuthor;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.priority = priority;
	}

	public AbstractCardWithStatisticsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Float getEf() {
		return this.ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	public ICardWithStatisticsData withEf(Float ef) {
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
	public ICardWithStatisticsData withInterval(Integer interval) {
		this.interval = interval;
		return this;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public ICardWithStatisticsData withCount(Integer count) {
		this.count = count;
		return this;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	public ICardWithStatisticsData withLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
		return this;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getNext() {
		return this.next;
	}
	public void setNext(java.time.LocalDateTime next) {
		this.next = next;
	}
	public ICardWithStatisticsData withNext(java.time.LocalDateTime next) {
		this.next = next;
		return this;
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public ICardWithStatisticsData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public ICardWithStatisticsData withGiven(String given) {
		this.given = given;
		return this;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	public ICardWithStatisticsData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public String getCardAuthor() {
		return this.cardAuthor;
	}
	public void setCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
	}
	public ICardWithStatisticsData withCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
		return this;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	public ICardWithStatisticsData withCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICardWithStatisticsData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public ICardWithStatisticsData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public ICardWithStatisticsData withPriority(Integer priority) {
		this.priority = priority;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.card.models.ICardWithInfoModel model) {
		this.next = model.getNext();
		this.cardId = model.getCardId();
		this.given = model.getGiven();
		this.wanted = model.getWanted();
		this.cardAuthor = model.getCardAuthor();
		this.cardIndex = model.getCardIndex();
		this.categoryId = model.getCategoryId();
		this.rootCategoryId = model.getRootCategoryId();
		this.priority = model.getPriority();
	}
	
}



/******* S.D.G. *******/



