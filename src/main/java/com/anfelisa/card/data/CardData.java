/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardData extends AbstractCardData implements ICardData {
	
	public CardData(
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("image") String image, 
		@JsonProperty("cardAuthor") String cardAuthor, 
		@JsonProperty("cardIndex") Integer cardIndex, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("priority") Integer priority, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			cardId,
			given,
			wanted,
			image,
			cardAuthor,
			cardIndex,
			categoryId,
			rootCategoryId,
			priority,
			uuid
		);
	}

	public CardData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.card.models.ICardModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.card.models.ICardModel testData = new com.anfelisa.card.models.CardModel();
		testData.setCardId(randomString(random));
		testData.setGiven(randomString(random));
		testData.setWanted(randomString(random));
		testData.setImage(randomString(random));
		testData.setCardAuthor(randomString(random));
		testData.setCardIndex(random.nextInt(50));
		testData.setCategoryId(randomString(random));
		testData.setRootCategoryId(randomString(random));
		testData.setPriority(random.nextInt(50));
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



