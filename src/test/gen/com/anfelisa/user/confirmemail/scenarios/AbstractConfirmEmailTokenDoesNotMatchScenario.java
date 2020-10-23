/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.user.confirmemail.scenarios;

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
public abstract class AbstractConfirmEmailTokenDoesNotMatchScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractConfirmEmailTokenDoesNotMatchScenario.class);
	
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

		if (prerequisite("RegisterTwoUsers")) {
			uuid = "uuid2-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN_2-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_1 = objectMapper.readValue("{" +
				"\"email\" : \"info@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"pw\"," + 
				"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"info@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"pw\"," + 
			"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/users/register", 
			 	payload_1,
				null,
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN RegisterTwoUsers fails\n" + response_1.getStatusMessage();
				LOG.info("GIVEN: RegisterTwoUsers fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterTwoUsers success in {} ms", response_1.getDuration());
			addToMetrics("RegisterUser", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterTwoUsers not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.ConfirmEmailPayload payload_0 = objectMapper.readValue("{" +
			"\"token\" : \"TOKEN_2-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.ConfirmEmailPayload.class);
		com.anfelisa.user.data.ConfirmEmailData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"token\" : \"TOKEN_2-" + this.getTestId() + "\"," + 
		"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.ConfirmEmailData.class);
		HttpResponse<Object> response = 
		this.httpPut(
			"/users/confirm", 
		 	payload_0,
			null,
			uuid,
			null
		);
		
		LOG.info("WHEN: ConfirmEmail finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("ConfirmEmail", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 400) {
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 400 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("ConfirmEmailTokenDoesNotMatch")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.confirmedIsNotSetToTrue();
			this.confirmedIsNotSetToTrueForOtherUser();
			this.tokenIsNotDeleted();
			this.otherTokenIsNotDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for ConfirmEmailTokenDoesNotMatch not met");
		}
	}
	
	
	private void confirmedIsNotSetToTrue() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"password\"," + 
			"\"role\" : \"STUDENT\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: confirmedIsNotSetToTrue passed");
	}
	private void confirmedIsNotSetToTrueForOtherUser() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Anne-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"info@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"pw\"," + 
			"\"role\" : \"STUDENT\"," + 
			"\"userId\" : \"uuid2-" + this.getTestId() + "\"," + 
			"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: confirmedIsNotSetToTrueForOtherUser passed");
	}
	private void tokenIsNotDeleted() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN-" + this.getTestId() + "");
		
		assertIsNotNull(actual);
	
		LOG.info("THEN: tokenIsNotDeleted passed");
	}
	private void otherTokenIsNotDeleted() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN_2-" + this.getTestId() + "");
		
		assertIsNotNull(actual);
	
		LOG.info("THEN: otherTokenIsNotDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ConfirmEmailTokenDoesNotMatch";
	}
	
}



/******* S.D.G. *******/



