/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.searchusername.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NonDeterministicDataProvider;
import de.acegen.HttpResponse;

@SuppressWarnings("unused")
public abstract class AbstractSearchUsernameExcludesMeScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractSearchUsernameExcludesMeScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			HttpResponse<Object> response_0 = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid,
				null
			);
			
			if (response_0.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response_0.getStatusMessage();
				LOG.error("GIVEN: RegisterUser fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"cat\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response_1.getStatusMessage();
				LOG.error("GIVEN: CreateBoxMinimal fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}

		if (prerequisite("RegisterTwoUsers")) {
			uuid = "uuid2-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN_2-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_2 = objectMapper.readValue("{" +
				"\"email\" : \"info@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"pw\"," + 
				"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"info@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"pw\"," + 
			"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/users/register", 
			 	payload_2,
				null,
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String message = "GIVEN RegisterTwoUsers fails\n" + response_2.getStatusMessage();
				LOG.error("GIVEN: RegisterTwoUsers fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterTwoUsers success in {} ms", response_2.getDuration());
			addToMetrics("RegisterUser", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterTwoUsers not met");
		}

	}
	
	private HttpResponse<com.anfelisa.category.data.SearchUsernameForInvitationResponse> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.category.data.UsernameSearchData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"usernameSearchString\" : \"Annette-" + this.getTestId() + "\"," + 
		"\"categoryId\" : \"boxId-" + this.getTestId() + "\"} ",
				com.anfelisa.category.data.UsernameSearchData.class);
		HttpResponse<com.anfelisa.category.data.SearchUsernameForInvitationResponse> response = 
		this.httpGet(
			"/users/search?usernameSearchString=" + data_0.getUsernameSearchString() + "&categoryId=" + data_0.getCategoryId() + "", 
			authorization("Annette-${testId}", "password"),
			uuid,
			com.anfelisa.category.data.SearchUsernameForInvitationResponse.class
		);
		
		LOG.info("WHEN: SearchUsernameForInvitation finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("SearchUsernameForInvitation", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.category.data.SearchUsernameForInvitationResponse then(HttpResponse<com.anfelisa.category.data.SearchUsernameForInvitationResponse> response) throws Exception {
		if (response.getStatusCode() == 500) {
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + response.getStatusMessage());
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 200) {
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 200: " + response.getStatusMessage());
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
				com.anfelisa.category.data.SearchUsernameForInvitationResponse actual = null;
				if (response.getStatusCode() < 400) {
					try {
						actual = response.getEntity();
						
					} catch (Exception x) {
						LOG.error("THEN: failed to read response", x);
						assertFail(x.getMessage());
					}

					com.anfelisa.category.data.UsernameSearchData expectedData = objectMapper.readValue("{" +
						"\"uuid\" : \"\"," + 
						"\"usernames\" : []} ",
					com.anfelisa.category.data.UsernameSearchData.class);
					
					com.anfelisa.category.data.SearchUsernameForInvitationResponse expected = new com.anfelisa.category.data.SearchUsernameForInvitationResponse(expectedData);
					
					assertThat(actual, expected);
					
					LOG.info("THEN: response passed");
				}

				return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("SearchUsernameExcludesMe")) {
			HttpResponse<com.anfelisa.category.data.SearchUsernameForInvitationResponse> response = when();

			com.anfelisa.category.data.SearchUsernameForInvitationResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for SearchUsernameExcludesMe not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "SearchUsernameExcludesMe";
	}
	
}



/******* S.D.G. *******/



