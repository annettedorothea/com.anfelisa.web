/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.user.deleteuser.scenarios;

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
public abstract class AbstractDeleteUserUnauthorizedScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteUserUnauthorizedScenario.class);
	
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
				LOG.info("GIVEN: RegisterUser fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.DeleteUserData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"usernameToBeDeleted\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.DeleteUserData.class);
		HttpResponse<Object> response = 
		this.httpDelete(
			"/user/delete?usernameToBeDeleted=" + data_0.getUsernameToBeDeleted() + "", 
			null,
			uuid,
			null
		);
		
		LOG.info("WHEN: DeleteUser finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("DeleteUser", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 401) {
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 401 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("DeleteUserUnauthorized")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.userWasNotDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for DeleteUserUnauthorized not met");
		}
	}
	
	
	private void userWasNotDeleted() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		assertIsNotNull(actual);
	
		LOG.info("THEN: userWasNotDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "DeleteUserUnauthorized";
	}
	
}



/******* S.D.G. *******/



