/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxStatisticsListData extends AbstractBoxStatisticsListData implements IBoxStatisticsListData {
	
	public BoxStatisticsListData(
		@JsonProperty("boxStatisticsList") java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsList, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			boxStatisticsList,
			userId,
			todayAtMidnightInUTC,
			uuid
		);
	}

	public BoxStatisticsListData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.IBoxStatisticsListModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		com.anfelisa.box.models.IBoxStatisticsListModel testData = new com.anfelisa.box.models.BoxStatisticsListModel();
		java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsListList = new java.util.ArrayList<com.anfelisa.box.models.IBoxStatisticsModel>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			boxStatisticsListList.add(com.anfelisa.box.data.BoxStatisticsData.generateTestData());
		}
		testData.setBoxStatisticsList(boxStatisticsListList);
		testData.setUserId(randomString(random));
		testData.setTodayAtMidnightInUTC(random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) );
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



