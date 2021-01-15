/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserToCategoryInvitationData extends AbstractUserToCategoryInvitationData implements IUserToCategoryInvitationData {
	
	public UserToCategoryInvitationData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("invitedUsername") String invitedUsername, 
		@JsonProperty("invitedUserId") String invitedUserId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			userId,
			invitedUsername,
			invitedUserId,
			uuid
		);
	}

	public UserToCategoryInvitationData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.category.models.IUserToCategoryInvitationModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.category.models.IUserToCategoryInvitationModel testData = new com.anfelisa.category.models.UserToCategoryInvitationModel();
		testData.setCategoryId(randomString(random));
		testData.setUserId(randomString(random));
		testData.setInvitedUsername(randomString(random));
		testData.setInvitedUserId(randomString(random));
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



