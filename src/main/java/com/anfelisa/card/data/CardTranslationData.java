/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardTranslationData extends AbstractCardTranslationData implements ICardTranslationData {
	
	public CardTranslationData(
		@JsonProperty("sourceValue") String sourceValue, 
		@JsonProperty("targetValue") String targetValue, 
		@JsonProperty("sourceLanguage") String sourceLanguage, 
		@JsonProperty("targetLanguage") String targetLanguage, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			sourceValue,
			targetValue,
			sourceLanguage,
			targetLanguage,
			uuid
		);
	}

	public CardTranslationData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.card.models.ICardTranslationModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.card.models.ICardTranslationModel testData = new com.anfelisa.card.models.CardTranslationModel();
		testData.setSourceValue(randomString(random));
		testData.setTargetValue(randomString(random));
		testData.setSourceLanguage(randomString(random));
		testData.setTargetLanguage(randomString(random));
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



