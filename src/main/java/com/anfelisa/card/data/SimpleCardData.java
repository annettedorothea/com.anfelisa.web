/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleCardData extends AbstractSimpleCardData implements ISimpleCardData {
	
	public SimpleCardData(
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("id") String id, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			given,
			wanted,
			id,
			uuid
		);
	}

	public SimpleCardData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.card.models.ISimpleCardModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.card.models.ISimpleCardModel testData = new com.anfelisa.card.models.SimpleCardModel();
		testData.setGiven(randomString(random));
		testData.setWanted(randomString(random));
		testData.setId(randomString(random));
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



