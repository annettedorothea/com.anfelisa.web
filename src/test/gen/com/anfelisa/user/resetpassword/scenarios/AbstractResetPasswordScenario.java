/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.resetpassword.scenarios;

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
public abstract class AbstractResetPasswordScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractResetPasswordScenario.class);
	
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

		if (prerequisite("ForgotPasswordOK")) {
			uuid = this.randomUUID();
			this.callNonDeterministicDataProviderPutValue(uuid, "token",	"RESET-PW-TOKEN-" + this.getTestId() + "");
			com.anfelisa.user.data.ForgotPasswordPayload payload_1 = objectMapper.readValue("{" +
				"\"language\" : \"de\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.ForgotPasswordPayload.class);
			com.anfelisa.user.data.ForgotPasswordData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"language\" : \"de\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.ForgotPasswordData.class);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/users/forgot-password", 
			 	payload_1,
				null,
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String statusMessage = response_1.getStatusMessage() != null ? response_1.getStatusMessage() : "";
				String message = "GIVEN ForgotPasswordOK fails\n" + statusMessage;
				LOG.error("GIVEN: ForgotPasswordOK fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ForgotPasswordOK success in {} ms", response_1.getDuration());
			addToMetrics("ForgotPassword", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ForgotPasswordOK not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.ResetPasswordPayload payload_0 = objectMapper.readValue("{" +
			"\"token\" : \"RESET-PW-TOKEN-" + this.getTestId() + "\"," + 
			"\"password\" : \"newPassword\"} ",
				com.anfelisa.user.data.ResetPasswordPayload.class);
		com.anfelisa.user.data.ResetPasswordWithNewPasswordData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"token\" : \"RESET-PW-TOKEN-" + this.getTestId() + "\"," + 
		"\"password\" : \"newPassword\"} ",
				com.anfelisa.user.data.ResetPasswordWithNewPasswordData.class);
		HttpResponse<Object> response = 
		this.httpPut(
			"/users/resetpassword", 
		 	payload_0,
			null,
			uuid,
			null
		);
		
		LOG.info("WHEN: ResetPassword finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("ResetPassword", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
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
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("ResetPassword")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.passwordWasChanged();
			this.tokenWasDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for ResetPassword not met");
		}
	}
	
	
	private void passwordWasChanged() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"newPassword\"," + 
			"\"role\" : \"STUDENT\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: passwordWasChanged passed");
	}
	private void tokenWasDeleted() throws Exception {
		com.anfelisa.user.models.IResetPasswordModel actual = daoProvider.getResetPasswordDao().selectByToken(handle, "RESET-PW-TOKEN-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: tokenWasDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ResetPassword";
	}
	
}



/******* S.D.G. *******/



