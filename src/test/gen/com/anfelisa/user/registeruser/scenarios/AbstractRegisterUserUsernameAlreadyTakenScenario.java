/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.registeruser.scenarios;

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
public abstract class AbstractRegisterUserUsernameAlreadyTakenScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterUserUsernameAlreadyTakenScenario.class);
	
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
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "uuid-at-" + this.getTestId() + "";
		this.callNonDeterministicDataProviderPutValue(uuid, "token",	"XXX-" + this.getTestId() + "");
		com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
			"\"email\" : \"info@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"pw\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.RegisterUserPayload.class);
		com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"email\" : \"info@anfelisa.de\"," + 
		"\"language\" : \"de\"," + 
		"\"password\" : \"pw\"," + 
		"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.UserRegistrationData.class);
		HttpResponse<Object> response = 
		this.httpPost(
			"/users/register", 
		 	payload_0,
			null,
			uuid,
			null
		);
		
		LOG.info("WHEN: RegisterUser finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("RegisterUser", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + statusMessage);
			assertFail(statusMessage);
		}
		if (response.getStatusCode() != 400) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 400: " + statusMessage);
			assertFail(statusMessage);
		} else {
			LOG.info("THEN: status 400 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("RegisterUserUsernameAlreadyTaken")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.userWasNotCreated();
			this.emailConfirmationWasNotCreated();
			this.existingUserWasNotTouched();
			this.existingEmailConfirmationWasNotTouched();
	
		} else {
			LOG.info("WHEN: prerequisite for RegisterUserUsernameAlreadyTaken not met");
		}
	}
	
	
	private void userWasNotCreated() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-at-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: userWasNotCreated passed");
	}
	private void emailConfirmationWasNotCreated() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "XXX-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: emailConfirmationWasNotCreated passed");
	}
	private void existingUserWasNotTouched() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"password\"," + 
			"\"role\" : \"STUDENT\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: existingUserWasNotTouched passed");
	}
	private void existingEmailConfirmationWasNotTouched() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IEmailConfirmationModel expected = objectMapper.readValue("{" +
			"\"token\" : \"TOKEN-" + this.getTestId() + "\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.EmailConfirmationModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: existingEmailConfirmationWasNotTouched passed");
	}
		
	@Override
	protected String scenarioName() {
		return "RegisterUserUsernameAlreadyTaken";
	}
	
}



/******* S.D.G. *******/



