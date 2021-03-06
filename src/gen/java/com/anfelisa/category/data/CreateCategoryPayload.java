/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class CreateCategoryPayload implements ICreateCategoryPayload {
	
	private String categoryName;
	
	private String parentCategoryId;
	
	public CreateCategoryPayload() {
	}
	
	public CreateCategoryPayload(com.anfelisa.category.models.ICategoryCreationModel data) {
		categoryName = data.getCategoryName();
		parentCategoryId = data.getParentCategoryId();
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	
}



/******* S.D.G. *******/



