/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryCreationData extends AbstractCategoryCreationData implements ICategoryCreationData {
	
	public CategoryCreationData(
		@JsonProperty("username") String username, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("categoryAuthor") String categoryAuthor, 
		@JsonProperty("categoryIndex") Integer categoryIndex, 
		@JsonProperty("parentCategoryId") String parentCategoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup, 
		@JsonProperty("givenLanguage") String givenLanguage, 
		@JsonProperty("wantedLanguage") String wantedLanguage, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
			userId,
			categoryId,
			categoryName,
			categoryAuthor,
			categoryIndex,
			parentCategoryId,
			rootCategoryId,
			dictionaryLookup,
			givenLanguage,
			wantedLanguage,
			uuid
		);
	}

	public CategoryCreationData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.category.models.ICategoryCreationModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.category.models.ICategoryCreationModel testData = new com.anfelisa.category.models.CategoryCreationModel();
		testData.setUsername(randomString(random));
		testData.setUserId(randomString(random));
		testData.setCategoryId(randomString(random));
		testData.setCategoryName(randomString(random));
		testData.setCategoryAuthor(randomString(random));
		testData.setCategoryIndex(random.nextInt(50));
		testData.setParentCategoryId(randomString(random));
		testData.setRootCategoryId(randomString(random));
		testData.setDictionaryLookup(random.nextBoolean());
		testData.setGivenLanguage(randomString(random));
		testData.setWantedLanguage(randomString(random));
		return testData;
	}
	
	private static String randomString(java.util.Random random) {
		String chars = "aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz";
		int n = random.nextInt(20) + 5;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		String string  = sb.toString(); 
		return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
	}
	
}



/******* S.D.G. *******/



