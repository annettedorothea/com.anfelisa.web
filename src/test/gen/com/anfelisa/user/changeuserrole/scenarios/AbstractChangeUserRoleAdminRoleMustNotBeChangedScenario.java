/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.user.changeuserrole.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NonDeterministicDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractChangeUserRoleAdminRoleMustNotBeChangedScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractChangeUserRoleAdminRoleMustNotBeChangedScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		Response response;
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
			response = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.ChangeUserRolePayload payload_0 = objectMapper.readValue("{" +
			"\"editedUserId\" : \"uuid-admin\"," + 
			"\"newRole\" : \"STUDENT\"} ",
				com.anfelisa.user.data.ChangeUserRolePayload.class);
		com.anfelisa.user.data.ChangeUserRoleData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"editedUserId\" : \"uuid-admin\"," + 
		"\"newRole\" : \"STUDENT\"} ",
				com.anfelisa.user.data.ChangeUserRoleData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpPut(
			"/user/role", 
		 	payload_0,
			authorization("Admin", "admin-password"),
			uuid
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: ChangeUserRole finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("ChangeUserRole", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 400) {
			String message = response.readEntity(String.class);
			assertFail(message);
		} else {
			LOG.info("THEN: status 400 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("ChangeUserRoleAdminRoleMustNotBeChanged")) {
			Response response = when();

			then(response);
			
			this.roleWasNotChanged();
	
			
			response.close();
		} else {
			LOG.info("WHEN: prerequisite for ChangeUserRoleAdminRoleMustNotBeChanged not met");
		}
	}
	
	
	private void roleWasNotChanged() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-admin");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"admin-password\"," + 
			"\"role\" : \"ADMIN\"," + 
			"\"userId\" : \"uuid-admin\"," + 
			"\"username\" : \"Admin\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: roleWasNotChanged passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ChangeUserRoleAdminRoleMustNotBeChanged";
	}
	
}



/******* S.D.G. *******/



