/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduledCardsData extends AbstractScheduledCardsData implements IScheduledCardsData {
	
	public ScheduledCardsData(
		@JsonProperty("newScheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards, 
		@JsonProperty("existingScheduledCardIds") java.util.List<String> existingScheduledCardIds, 
		@JsonProperty("cardIds") java.util.List<String> cardIds, 
		@JsonProperty("scheduledDate") java.time.LocalDateTime scheduledDate, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("reverse") Boolean reverse, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			newScheduledCards,
			existingScheduledCardIds,
			cardIds,
			scheduledDate,
			userId,
			boxId,
			reverse,
			uuid
		);
	}

	public ScheduledCardsData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.IScheduledCardsModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		com.anfelisa.box.models.IScheduledCardsModel testData = new com.anfelisa.box.models.ScheduledCardsModel();
		java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCardsList = new java.util.ArrayList<com.anfelisa.box.models.IScheduledCardModel>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			newScheduledCardsList.add(com.anfelisa.box.data.ScheduledCardData.generateTestData());
		}
		testData.setNewScheduledCards(newScheduledCardsList);
		java.util.List<String> existingScheduledCardIdsList = new java.util.ArrayList<String>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			existingScheduledCardIdsList.add(randomString(random));
		}
		testData.setExistingScheduledCardIds(existingScheduledCardIdsList);
		java.util.List<String> cardIdsList = new java.util.ArrayList<String>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			cardIdsList.add(randomString(random));
		}
		testData.setCardIds(cardIdsList);
		testData.setScheduledDate(random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) );
		testData.setUserId(randomString(random));
		testData.setBoxId(randomString(random));
		testData.setReverse(random.nextBoolean());
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



