package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.ICategoryCreationModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCategoryCreationData extends AbstractData implements ICategoryCreationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCategoryCreationData.class);
	
	private String username;
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private String categoryAuthor;
	
	@NotNull
	private Integer categoryIndex;
	
	private String parentCategoryId;
	
	private String rootCategoryId;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	private Boolean publicRootCategory = false;
	
	@NotNull
	private String userId;
	

	public AbstractCategoryCreationData(
		@JsonProperty("username") String username,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("publicRootCategory") Boolean publicRootCategory,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
		this.rootCategoryId = rootCategoryId;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.publicRootCategory = publicRootCategory;
		this.userId = userId;
	}

	public AbstractCategoryCreationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ICategoryCreationData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICategoryCreationData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public ICategoryCreationData withCategoryName(String categoryName) {
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
	public ICategoryCreationData withCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public ICategoryCreationData withCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
		return this;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public ICategoryCreationData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public ICategoryCreationData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public Boolean getDictionaryLookup() {
		return this.dictionaryLookup;
	}
	public void setDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
	}
	public ICategoryCreationData withDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
		return this;
	}
	
	@JsonProperty
	public String getGivenLanguage() {
		return this.givenLanguage;
	}
	public void setGivenLanguage(String givenLanguage) {
		this.givenLanguage = givenLanguage;
	}
	public ICategoryCreationData withGivenLanguage(String givenLanguage) {
		this.givenLanguage = givenLanguage;
		return this;
	}
	
	@JsonProperty
	public String getWantedLanguage() {
		return this.wantedLanguage;
	}
	public void setWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
	}
	public ICategoryCreationData withWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
		return this;
	}
	
	@JsonProperty
	public Boolean getPublicRootCategory() {
		return this.publicRootCategory;
	}
	public void setPublicRootCategory(Boolean publicRootCategory) {
		this.publicRootCategory = publicRootCategory;
	}
	public ICategoryCreationData withPublicRootCategory(Boolean publicRootCategory) {
		this.publicRootCategory = publicRootCategory;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICategoryCreationData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.category.models.ICategoryModel model) {
		this.categoryId = model.getCategoryId();
		this.categoryName = model.getCategoryName();
		this.categoryAuthor = model.getCategoryAuthor();
		this.categoryIndex = model.getCategoryIndex();
		this.parentCategoryId = model.getParentCategoryId();
		this.rootCategoryId = model.getRootCategoryId();
		this.dictionaryLookup = model.getDictionaryLookup();
		this.givenLanguage = model.getGivenLanguage();
		this.wantedLanguage = model.getWantedLanguage();
		this.publicRootCategory = model.getPublicRootCategory();
	}
	public void mapFrom(com.anfelisa.category.models.IUserAccessToCategoryModel model) {
		this.categoryId = model.getCategoryId();
		this.userId = model.getUserId();
	}
	
	public List<String> equalsPrimitiveTypes(ICategoryCreationModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		return differingAttributes;
	}
	
	public List<String> equalsPrimitiveTypes(ICategoryModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getCategoryName() == null && other.getCategoryName() == null) && !this.getCategoryName().equals(other.getCategoryName())) {
			differingAttributes.add("categoryName: " + this.getCategoryName() + " " + other.getCategoryName());
		}
		if (!(this.getCategoryAuthor() == null && other.getCategoryAuthor() == null) && !this.getCategoryAuthor().equals(other.getCategoryAuthor())) {
			differingAttributes.add("categoryAuthor: " + this.getCategoryAuthor() + " " + other.getCategoryAuthor());
		}
		if (!(this.getCategoryIndex() == null && other.getCategoryIndex() == null) && !this.getCategoryIndex().equals(other.getCategoryIndex())) {
			differingAttributes.add("categoryIndex: " + this.getCategoryIndex() + " " + other.getCategoryIndex());
		}
		if (!(this.getParentCategoryId() == null && other.getParentCategoryId() == null) && !this.getParentCategoryId().equals(other.getParentCategoryId())) {
			differingAttributes.add("parentCategoryId: " + this.getParentCategoryId() + " " + other.getParentCategoryId());
		}
		if (!(this.getRootCategoryId() == null && other.getRootCategoryId() == null) && !this.getRootCategoryId().equals(other.getRootCategoryId())) {
			differingAttributes.add("rootCategoryId: " + this.getRootCategoryId() + " " + other.getRootCategoryId());
		}
		if (!(this.getDictionaryLookup() == null && other.getDictionaryLookup() == null) && !this.getDictionaryLookup().equals(other.getDictionaryLookup())) {
			differingAttributes.add("dictionaryLookup: " + this.getDictionaryLookup() + " " + other.getDictionaryLookup());
		}
		if (!(this.getGivenLanguage() == null && other.getGivenLanguage() == null) && !this.getGivenLanguage().equals(other.getGivenLanguage())) {
			differingAttributes.add("givenLanguage: " + this.getGivenLanguage() + " " + other.getGivenLanguage());
		}
		if (!(this.getWantedLanguage() == null && other.getWantedLanguage() == null) && !this.getWantedLanguage().equals(other.getWantedLanguage())) {
			differingAttributes.add("wantedLanguage: " + this.getWantedLanguage() + " " + other.getWantedLanguage());
		}
		if (!(this.getPublicRootCategory() == null && other.getPublicRootCategory() == null) && !this.getPublicRootCategory().equals(other.getPublicRootCategory())) {
			differingAttributes.add("publicRootCategory: " + this.getPublicRootCategory() + " " + other.getPublicRootCategory());
		}
		return differingAttributes;
	}
	
	public List<String> equalsPrimitiveTypes(IUserAccessToCategoryModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
