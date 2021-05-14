/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxViewData extends AbstractBoxViewData implements IBoxViewData {
	
	public BoxViewData(
		@JsonProperty("openTodaysCards") Integer openTodaysCards, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("categoryAuthor") String categoryAuthor, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("reverse") Boolean reverse, 
		@JsonProperty("editable") Boolean editable, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			openTodaysCards,
			categoryName,
			categoryAuthor,
			categoryId,
			boxId,
			reverse,
			editable,
			uuid
		);
	}

	public BoxViewData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.IBoxViewModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.box.models.IBoxViewModel testData = new com.anfelisa.box.models.BoxViewModel();
		testData.setOpenTodaysCards(random.nextInt(50));
		testData.setCategoryName(randomString(random));
		testData.setCategoryAuthor(randomString(random));
		testData.setCategoryId(randomString(random));
		testData.setBoxId(randomString(random));
		testData.setReverse(random.nextBoolean());
		testData.setEditable(random.nextBoolean());
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



