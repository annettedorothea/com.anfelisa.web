/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxSettingsWrapperData extends AbstractBoxSettingsWrapperData implements IBoxSettingsWrapperData {
	
	public BoxSettingsWrapperData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("maxInterval") Integer maxInterval, 
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup, 
		@JsonProperty("givenLanguage") String givenLanguage, 
		@JsonProperty("wantedLanguage") String wantedLanguage, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("allCards") Integer allCards, 
		@JsonProperty("allActiveCards") Integer allActiveCards, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			boxId,
			maxInterval,
			maxCardsPerDay,
			categoryName,
			dictionaryLookup,
			givenLanguage,
			wantedLanguage,
			categoryId,
			allCards,
			allActiveCards,
			uuid
		);
	}

	public BoxSettingsWrapperData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.IBoxSettingsWrapperModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.box.models.IBoxSettingsWrapperModel testData = new com.anfelisa.box.models.BoxSettingsWrapperModel();
		testData.setUserId(randomString(random));
		testData.setBoxId(randomString(random));
		testData.setMaxInterval(random.nextInt(50));
		testData.setMaxCardsPerDay(random.nextInt(50));
		testData.setCategoryName(randomString(random));
		testData.setDictionaryLookup(random.nextBoolean());
		testData.setGivenLanguage(randomString(random));
		testData.setWantedLanguage(randomString(random));
		testData.setCategoryId(randomString(random));
		testData.setAllCards(random.nextInt(50));
		testData.setAllActiveCards(random.nextInt(50));
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



