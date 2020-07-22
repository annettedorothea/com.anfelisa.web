/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * generated with de.acegen 0.9.7
 *
 */




package com.anfelisa.user.registeruser.scenarios;

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
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractRegisterUserEmptyUsernameScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterUserEmptyUsernameScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		Response response;
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
	}
	
	private Response when() throws Exception {
		String uuid = "uuid-" + this.getTestId() + "";
		this.callNotReplayableDataProviderPutValue(uuid, "token", 
					objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
		com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"\"} ",
		com.anfelisa.user.data.UserRegistrationData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpPost(
			"/users/register", 
			data_0,
			null
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: RegisterUser finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private com.anfelisa.user.data.RegisterUserResponse then(Response response) throws Exception {
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
		
		com.anfelisa.user.data.RegisterUserResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.RegisterUserResponse.class);
		} catch (Exception x) {
		}
		
		return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("RegisterUserEmptyUsername")) {
			Response response = when();

			com.anfelisa.user.data.RegisterUserResponse actualResponse = then(response);
			
			this.userWasNotCreated();
			this.emailConfirmationWasNotCreated();
		
		} else {
			LOG.info("WHEN: prerequisite for RegisterUserEmptyUsername not met");
		}
	}
	
	
	private void userWasNotCreated() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-" + this.getTestId() + "");
		
		assertIsNull(actual);

		LOG.info("THEN: userWasNotCreated passed");
	}
	private void emailConfirmationWasNotCreated() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN-" + this.getTestId() + "");
		
		assertIsNull(actual);

		LOG.info("THEN: emailConfirmationWasNotCreated passed");
	}
	
	@Override
	protected String scenarioName() {
		return "RegisterUserEmptyUsername";
	}

}



/******* S.D.G. *******/


			
