/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxData extends AbstractBoxData implements IBoxData {
	
	public BoxData(
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("maxInterval") Integer maxInterval, 
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			boxId,
			userId,
			categoryId,
			maxInterval,
			maxCardsPerDay,
			uuid
		);
	}

	public BoxData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.IBoxModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.box.models.IBoxModel testData = new com.anfelisa.box.models.BoxModel();
		testData.setBoxId(randomString(random));
		testData.setUserId(randomString(random));
		testData.setCategoryId(randomString(random));
		testData.setMaxInterval(random.nextInt(50));
		testData.setMaxCardsPerDay(random.nextInt(50));
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



