/********************************************************************************
 * generated by de.acegen 0.9.13
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
public abstract class AbstractDeleteAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteAdminScenario.class);
	
	private void given() throws Exception {
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"admin-password\"," + 
			"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_0 = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_0.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response_0.getStatusMessage();
				LOG.info("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_1 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/users/register", 
			 	payload_1,
				null,
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response_1.getStatusMessage();
				LOG.info("GIVEN: RegisterUser fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}

		if (prerequisite("ChangeUserRoleToAdmin")) {
			uuid = this.randomUUID();
			com.anfelisa.user.data.ChangeUserRolePayload payload_2 = objectMapper.readValue("{" +
				"\"editedUserId\" : \"uuid-" + this.getTestId() + "\"," + 
				"\"newRole\" : \"ADMIN\"} ",
					com.anfelisa.user.data.ChangeUserRolePayload.class);
			com.anfelisa.user.data.ChangeUserRoleData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"editedUserId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"newRole\" : \"ADMIN\"} ",
					com.anfelisa.user.data.ChangeUserRoleData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_2 = 
			this.httpPut(
				"/user/role", 
			 	payload_2,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_2.getStatusCode() >= 400) {
				String message = "GIVEN ChangeUserRoleToAdmin fails\n" + response_2.getStatusMessage();
				LOG.info("GIVEN: ChangeUserRoleToAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ChangeUserRole", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ChangeUserRoleToAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ChangeUserRole", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ChangeUserRoleToAdmin not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.DeleteUserData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"usernameToBeDeleted\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.DeleteUserData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		HttpResponse<Object> response = 
		this.httpDelete(
			"/user/delete?usernameToBeDeleted=" + data_0.getUsernameToBeDeleted() + "", 
			authorization("Admin", "admin-password"),
			uuid,
			null
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: DeleteUser finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("DeleteUser", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 200) {
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("DeleteAdmin")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.userWasDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for DeleteAdmin not met");
		}
	}
	
	
	private void userWasDeleted() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: userWasDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "DeleteAdmin";
	}
	
}



/******* S.D.G. *******/



