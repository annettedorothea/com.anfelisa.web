/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgotPasswordData extends AbstractForgotPasswordData implements IForgotPasswordData {
	
	public ForgotPasswordData(
		@JsonProperty("language") String language, 
		@JsonProperty("email") String email, 
		@JsonProperty("username") String username, 
		@JsonProperty("token") String token, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			language,
			email,
			username,
			token,
			userId,
			uuid
		);
	}

	public ForgotPasswordData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.user.models.IForgotPasswordModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.user.models.IForgotPasswordModel testData = new com.anfelisa.user.models.ForgotPasswordModel();
		testData.setLanguage(randomString(random));
		testData.setEmail(randomString(random));
		testData.setUsername(randomString(random));
		testData.setToken(randomString(random));
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



