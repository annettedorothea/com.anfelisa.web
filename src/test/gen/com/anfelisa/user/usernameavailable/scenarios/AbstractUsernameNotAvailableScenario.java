/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.user.usernameavailable.scenarios;

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
public abstract class AbstractUsernameNotAvailableScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUsernameNotAvailableScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutValue(uuid, "token",	"TOKEN-" + this.getTestId() + "");
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
				String statusMessage = response_0.getStatusMessage() != null ? response_0.getStatusMessage() : "";
				String message = "GIVEN RegisterUser fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterUser fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}

	}
	
	private HttpResponse<com.anfelisa.user.data.UsernameAvailableResponse> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.UsernameAvailableData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.UsernameAvailableData.class);
		HttpResponse<com.anfelisa.user.data.UsernameAvailableResponse> response = 
		this.httpGet(
			"/users/username?username=" + data_0.getUsername() + "", 
			null,
			uuid,
			com.anfelisa.user.data.UsernameAvailableResponse.class
		);
		
		LOG.info("WHEN: UsernameAvailable finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("UsernameAvailable", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.user.data.UsernameAvailableResponse then(HttpResponse<com.anfelisa.user.data.UsernameAvailableResponse> response) throws Exception {
		if (response.getStatusCode() == 500) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + statusMessage);
			assertFail(statusMessage);
		}
		if (response.getStatusCode() != 200) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 200: " + statusMessage);
			assertFail(statusMessage);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
				com.anfelisa.user.data.UsernameAvailableResponse actual = null;
				if (response.getStatusCode() < 400) {
					try {
						actual = response.getEntity();
						
					} catch (Exception x) {
						LOG.error("THEN: failed to read response", x);
						assertFail(x.getMessage());
					}

					com.anfelisa.user.data.UsernameAvailableData expectedData = objectMapper.readValue("{" +
						"\"uuid\" : \"\"," + 
						"\"available\" : false} ",
					com.anfelisa.user.data.UsernameAvailableData.class);
					
					com.anfelisa.user.data.UsernameAvailableResponse expected = new com.anfelisa.user.data.UsernameAvailableResponse(expectedData);
					
					assertThat(actual, expected);
					
					LOG.info("THEN: response passed");
				}

				return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("UsernameNotAvailable")) {
			HttpResponse<com.anfelisa.user.data.UsernameAvailableResponse> response = when();

			com.anfelisa.user.data.UsernameAvailableResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for UsernameNotAvailable not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "UsernameNotAvailable";
	}
	
}



/******* S.D.G. *******/



