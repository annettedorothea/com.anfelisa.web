package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CategoryListModel implements ICategoryListModel {

	private String parentCategoryId;
	
	private String grandParentCategoryId;
	
	private String parentCategoryName;
	
	private java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList;
	

	public CategoryListModel(
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("grandParentCategoryId") String grandParentCategoryId,
		@JsonProperty("parentCategoryName") String parentCategoryName,
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList
	) {
		this.parentCategoryId = parentCategoryId;
		this.grandParentCategoryId = grandParentCategoryId;
		this.parentCategoryName = parentCategoryName;
		this.categoryList = categoryList;
	}

	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	@JsonProperty
	public String getGrandParentCategoryId() {
		return this.grandParentCategoryId;
	}
	public void setGrandParentCategoryId(String grandParentCategoryId) {
		this.grandParentCategoryId = grandParentCategoryId;
	}
	
	@JsonProperty
	public String getParentCategoryName() {
		return this.parentCategoryName;
	}
	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList) {
		this.categoryList = categoryList;
	}
	

}

/*       S.D.G.       */
