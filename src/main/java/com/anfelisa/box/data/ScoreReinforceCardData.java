/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreReinforceCardData extends AbstractScoreReinforceCardData implements IScoreReinforceCardData {
	
	public ScoreReinforceCardData(
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("keep") Boolean keep, 
		@JsonProperty("changeDate") java.time.LocalDateTime changeDate, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			reinforceCardId,
			keep,
			changeDate,
			userId,
			uuid
		);
	}

	public ScoreReinforceCardData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.IScoreReinforceCardModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.box.models.IScoreReinforceCardModel testData = new com.anfelisa.box.models.ScoreReinforceCardModel();
		testData.setReinforceCardId(randomString(random));
		testData.setKeep(random.nextBoolean());
		testData.setChangeDate(random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) );
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



