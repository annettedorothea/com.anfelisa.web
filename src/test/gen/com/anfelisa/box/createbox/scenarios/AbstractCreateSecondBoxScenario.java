/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.box.createbox.scenarios;

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
public abstract class AbstractCreateSecondBoxScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateSecondBoxScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		Response response;
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		
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
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"cat\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.BoxCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Annette-${testId}", "password"),
				uuid
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
		String uuid = "boxId2-" + this.getTestId() + "";
		com.anfelisa.box.data.CreateBoxPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 8} ",
				com.anfelisa.box.data.CreateBoxPayload.class);
		com.anfelisa.box.data.BoxCreationData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"categoryName\" : \"cat2-" + this.getTestId() + "\"," + 
		"\"dictionaryLookup\" : false," + 
		"\"maxCardsPerDay\" : 8} ",
				com.anfelisa.box.data.BoxCreationData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpPost(
			"/box/create", 
		 	payload_0,
			authorization("Annette-${testId}", "password"),
			uuid
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: CreateBox finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
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
			
		if (prerequisite("CreateSecondBox")) {
			Response response = when();

			then(response);
			
			this.categoryWasCreated();
			this.accessToCategoryWasGranted();
			this.boxWasCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for CreateSecondBox not met");
		}
	}
	
	
	private void categoryWasCreated() throws Exception {
		com.anfelisa.category.models.ICategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "boxId2-" + this.getTestId() + "");
		
		com.anfelisa.category.models.ICategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"categoryIndex\" : null," + 
			"\"categoryName\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"parentCategoryId\" : null," + 
			"\"rootCategoryId\" : \"boxId2-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: categoryWasCreated passed");
	}
	private void accessToCategoryWasGranted() throws Exception {
		com.anfelisa.category.models.IUserAccessToCategoryModel actual = daoProvider.getUserAccessToCategoryDao().selectByPrimaryKey(handle, "boxId2-" + this.getTestId() + "", "uuid-" + this.getTestId() + "");
		
		com.anfelisa.category.models.IUserAccessToCategoryModel expected = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"editable\" : true," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.UserAccessToCategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: accessToCategoryWasGranted passed");
	}
	private void boxWasCreated() throws Exception {
		com.anfelisa.box.models.IBoxModel actual = daoProvider.getBoxDao().selectByBoxId(handle, "boxId2-" + this.getTestId() + "");
		
		com.anfelisa.box.models.IBoxModel expected = objectMapper.readValue("{" +
			"\"boxId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"maxCardsPerDay\" : 8," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"} ",
		com.anfelisa.box.models.BoxModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: boxWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "CreateSecondBox";
	}
	
}



/******* S.D.G. *******/



