/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class CardCreationModel implements ICardCreationModel {

	private String userId;

	private String username;

	private String cardId;

	private String given;

	private String wanted;

	private String cardAuthor;

	private Integer cardIndex;

	private String categoryId;

	private String rootCategoryId;

	private Integer priority;


	public CardCreationModel() {
	}

	public CardCreationModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("priority") Integer priority
	) {
		this.userId = userId;
		this.username = username;
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.cardAuthor = cardAuthor;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.priority = priority;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	@JsonProperty
	public String getCardAuthor() {
		return this.cardAuthor;
	}
	public void setCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	

}



/******* S.D.G. *******/



