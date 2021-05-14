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
import com.anfelisa.box.models.IBoxWithStatisticsModel;
import com.anfelisa.box.models.IBoxViewModel;
import com.anfelisa.box.models.IBoxStatisticsModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractBoxWithStatisticsData extends AbstractData implements IBoxWithStatisticsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxWithStatisticsData.class);
	
	private Integer openTodaysCards;
	
	private String categoryName;
	
	private String categoryAuthor;
	
	private String categoryId;
	
	private String boxId;
	
	private Boolean reverse = false;
	
	private Boolean editable = false;
	
	private Integer quality0Count;
	
	private Integer quality1Count;
	
	private Integer quality2Count;
	
	private Integer quality3Count;
	
	private Integer quality4Count;
	
	private Integer quality5Count;
	
	private java.util.List<Integer> countsPerDayNextWeek;
	
	private Integer maxCardsPerDay;
	

	public AbstractBoxWithStatisticsData(
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("quality0Count") Integer quality0Count,
		@JsonProperty("quality1Count") Integer quality1Count,
		@JsonProperty("quality2Count") Integer quality2Count,
		@JsonProperty("quality3Count") Integer quality3Count,
		@JsonProperty("quality4Count") Integer quality4Count,
		@JsonProperty("quality5Count") Integer quality5Count,
		@JsonProperty("countsPerDayNextWeek") java.util.List<Integer> countsPerDayNextWeek,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.openTodaysCards = openTodaysCards;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryId = categoryId;
		this.boxId = boxId;
		this.reverse = reverse;
		this.editable = editable;
		this.quality0Count = quality0Count;
		this.quality1Count = quality1Count;
		this.quality2Count = quality2Count;
		this.quality3Count = quality3Count;
		this.quality4Count = quality4Count;
		this.quality5Count = quality5Count;
		this.countsPerDayNextWeek = countsPerDayNextWeek;
		this.maxCardsPerDay = maxCardsPerDay;
	}

	public AbstractBoxWithStatisticsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	public IBoxWithStatisticsData withOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public IBoxWithStatisticsData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public String getCategoryAuthor() {
		return this.categoryAuthor;
	}
	public void setCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
	}
	public IBoxWithStatisticsData withCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IBoxWithStatisticsData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IBoxWithStatisticsData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	public IBoxWithStatisticsData withReverse(Boolean reverse) {
		this.reverse = reverse;
		return this;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public IBoxWithStatisticsData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality0Count() {
		return this.quality0Count;
	}
	public void setQuality0Count(Integer quality0Count) {
		this.quality0Count = quality0Count;
	}
	public IBoxWithStatisticsData withQuality0Count(Integer quality0Count) {
		this.quality0Count = quality0Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality1Count() {
		return this.quality1Count;
	}
	public void setQuality1Count(Integer quality1Count) {
		this.quality1Count = quality1Count;
	}
	public IBoxWithStatisticsData withQuality1Count(Integer quality1Count) {
		this.quality1Count = quality1Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality2Count() {
		return this.quality2Count;
	}
	public void setQuality2Count(Integer quality2Count) {
		this.quality2Count = quality2Count;
	}
	public IBoxWithStatisticsData withQuality2Count(Integer quality2Count) {
		this.quality2Count = quality2Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality3Count() {
		return this.quality3Count;
	}
	public void setQuality3Count(Integer quality3Count) {
		this.quality3Count = quality3Count;
	}
	public IBoxWithStatisticsData withQuality3Count(Integer quality3Count) {
		this.quality3Count = quality3Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality4Count() {
		return this.quality4Count;
	}
	public void setQuality4Count(Integer quality4Count) {
		this.quality4Count = quality4Count;
	}
	public IBoxWithStatisticsData withQuality4Count(Integer quality4Count) {
		this.quality4Count = quality4Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality5Count() {
		return this.quality5Count;
	}
	public void setQuality5Count(Integer quality5Count) {
		this.quality5Count = quality5Count;
	}
	public IBoxWithStatisticsData withQuality5Count(Integer quality5Count) {
		this.quality5Count = quality5Count;
		return this;
	}
	
	@JsonProperty
	public java.util.List<Integer> getCountsPerDayNextWeek() {
		return this.countsPerDayNextWeek;
	}
	public void setCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek) {
		this.countsPerDayNextWeek = countsPerDayNextWeek;
	}
	public IBoxWithStatisticsData withCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek) {
		this.countsPerDayNextWeek = countsPerDayNextWeek;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
	}
	public IBoxWithStatisticsData withMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.box.models.IBoxViewModel model) {
		this.openTodaysCards = model.getOpenTodaysCards();
		this.categoryName = model.getCategoryName();
		this.categoryAuthor = model.getCategoryAuthor();
		this.categoryId = model.getCategoryId();
		this.boxId = model.getBoxId();
		this.reverse = model.getReverse();
		this.editable = model.getEditable();
	}
	public void mapFrom(com.anfelisa.box.models.IBoxStatisticsModel model) {
		this.boxId = model.getBoxId();
		this.quality0Count = model.getQuality0Count();
		this.quality1Count = model.getQuality1Count();
		this.quality2Count = model.getQuality2Count();
		this.quality3Count = model.getQuality3Count();
		this.quality4Count = model.getQuality4Count();
		this.quality5Count = model.getQuality5Count();
		this.countsPerDayNextWeek = model.getCountsPerDayNextWeek();
		this.maxCardsPerDay = model.getMaxCardsPerDay();
	}
	
}



/******* S.D.G. *******/



