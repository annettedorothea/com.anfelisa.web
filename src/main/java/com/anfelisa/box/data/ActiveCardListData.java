/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActiveCardListData extends AbstractActiveCardListData implements IActiveCardListData {
	
	public ActiveCardListData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("cardList") java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			boxId,
			cardList,
			uuid
		);
	}

	public ActiveCardListData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.IActiveCardListModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		com.anfelisa.box.models.IActiveCardListModel testData = new com.anfelisa.box.models.ActiveCardListModel();
		testData.setUserId(randomString(random));
		testData.setBoxId(randomString(random));
		java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardListList = new java.util.ArrayList<com.anfelisa.box.models.ICardWithStatisticsModel>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			cardListList.add(com.anfelisa.box.data.CardWithStatisticsData.generateTestData());
		}
		testData.setCardList(cardListList);
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



