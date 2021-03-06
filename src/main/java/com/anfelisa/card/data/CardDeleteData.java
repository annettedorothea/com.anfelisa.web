/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDeleteData extends AbstractCardDeleteData implements ICardDeleteData {
	
	public CardDeleteData(
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("cardIndex") Integer cardIndex, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			cardId,
			cardIndex,
			categoryId,
			userId,
			uuid
		);
	}

	public CardDeleteData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.card.models.ICardDeleteModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.card.models.ICardDeleteModel testData = new com.anfelisa.card.models.CardDeleteModel();
		testData.setCardId(randomString(random));
		testData.setCardIndex(random.nextInt(50));
		testData.setCategoryId(randomString(random));
		testData.setUserId(randomString(random));
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



