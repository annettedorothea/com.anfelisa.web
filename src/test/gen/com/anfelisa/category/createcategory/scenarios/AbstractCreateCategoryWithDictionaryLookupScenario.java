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
 */




package com.anfelisa.category.createcategory.scenarios;

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
public abstract class AbstractCreateCategoryWithDictionaryLookupScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateCategoryWithDictionaryLookupScenario.class);
	
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
		

		if (prerequisite("CreateBoxDictionaryLookup")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"maxCardsPerDay\" : 10," + 
					"\"dictionaryLookup\" : true," + 
					"\"givenLanguage\" : \"de\"," + 
					"\"wantedLanguage\" : \"en\"} ",
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
				String message = "GIVEN CreateBoxDictionaryLookup fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxDictionaryLookup fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxDictionaryLookup success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxDictionaryLookup not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = "dict-" + this.getTestId() + "";
		com.anfelisa.category.data.CategoryCreationData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"categoryName\" : \"dict-" + this.getTestId() + "\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.data.CategoryCreationData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpPost(
			"/category/create", 
			data_0,
			authorization("Annette-${testId}", "password")
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: CreateCategory finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("CreateCategoryWithDictionaryLookup")) {
			Response response = when();

			then(response);
			
			this.categoryWasCreated();
		
		} else {
			LOG.info("WHEN: prerequisite for CreateCategoryWithDictionaryLookup not met");
		}
	}
	
	
	private void categoryWasCreated() throws Exception {
		com.anfelisa.category.models.ICategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "dict-" + this.getTestId() + "");
		
		com.anfelisa.category.models.ICategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
				"\"categoryId\" : \"dict-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : 1," + 
				"\"categoryName\" : \"dict-" + this.getTestId() + "\"," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);

		LOG.info("THEN: categoryWasCreated passed");
	}
	
	@Override
	protected String scenarioName() {
		return "CreateCategoryWithDictionaryLookup";
	}

}



/******* S.D.G. *******/


			
