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
 * generated with de.acegen 0.9.6
 *
 */




package com.anfelisa.box.updatebox.scenarios;

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
public abstract class AbstractUpdateBoxCategoryNameBlankScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUpdateBoxCategoryNameBlankScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"password\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.UserRegistrationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/users/register", 
				data_1,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUser fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/box/create", 
				data_2,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxMinimal fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.box.data.BoxUpdateData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"categoryName\" : \"    \"," + 
				"\"maxCardsPerDay\" : 20} ",
		com.anfelisa.box.data.BoxUpdateData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpPut(
			"/box/update?uuid=" + data_0.getUuid() + "", 
			data_0,
			authorization("Annette-${testId}", "password")
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: UpdateBox finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("UpdateBox", (timeAfterRequest-timeBeforeRequest));
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
			
		if (prerequisite("UpdateBoxCategoryNameBlank")) {
			Response response = when();

			then(response);
			
			this.categoryWasNotUpdated();
			this.boxWasNotUpdated();
		
		} else {
			LOG.info("WHEN: prerequisite for UpdateBoxCategoryNameBlank not met");
		}
	}
	
	
	private void categoryWasNotUpdated() throws Exception {
		com.anfelisa.category.models.ICategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "boxId-" + this.getTestId() + "");
		
		com.anfelisa.category.models.ICategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
				"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : null," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"parentCategoryId\" : null," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);

		LOG.info("THEN: categoryWasNotUpdated passed");
	}
	private void boxWasNotUpdated() throws Exception {
		com.anfelisa.box.models.IBoxModel actual = daoProvider.getBoxDao().selectByBoxId(handle, "boxId-" + this.getTestId() + "");
		
		com.anfelisa.box.models.IBoxModel expected = objectMapper.readValue("{" +
			"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"maxCardsPerDay\" : 10," + 
				"\"userId\" : \"uuid-" + this.getTestId() + "\"} ",
		com.anfelisa.box.models.BoxModel.class);
		assertThat(actual, expected);

		LOG.info("THEN: boxWasNotUpdated passed");
	}
	
	@Override
	protected String scenarioName() {
		return "UpdateBoxCategoryNameBlank";
	}

}



/******* S.D.G. *******/


			
