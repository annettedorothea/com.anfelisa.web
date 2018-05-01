package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

public class CategoryListData extends AbstractData implements ICategoryListData {
	
	private String parentCategoryId;
	
	private String parentCategoryName;
	
	private java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList;
	

	public CategoryListData(
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("parentCategoryName") String parentCategoryName,
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.parentCategoryId = parentCategoryId;
		this.parentCategoryName = parentCategoryName;
		this.categoryList = categoryList;
	}

	public CategoryListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public CategoryListData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getParentCategoryName() {
		return this.parentCategoryName;
	}
	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}
	public CategoryListData withParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList) {
		this.categoryList = categoryList;
	}
	public CategoryListData withCategoryList(java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList) {
		this.categoryList = categoryList;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryListPresentationalData(
			this.parentCategoryId,
			this.parentCategoryName,
			this.categoryList
		);
	}

}

/*       S.D.G.       */
