/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.card.importcsv.scenarios;

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
public abstract class AbstractImportCsvUnauthorizedScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractImportCsvUnauthorizedScenario.class);
	
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

		if (prerequisite("CreateCategory")) {
			uuid = "cat1-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"level 1 #1\"," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/category/create", 
			 	payload_2,
				authorization("Annette-${testId}", "password"),
				uuid
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategory fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.card.data.ImportCsvPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"previewCsv\" : [ { \"given\" : \"g1\"," + 
			"\"wanted\" : \"w1\"," + 
			"\"id\" : \"1-" + this.getTestId() + "\"}]} ",
				com.anfelisa.card.data.ImportCsvPayload.class);
		com.anfelisa.card.data.CsvUploadData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
		"\"previewCsv\" : [ { \"given\" : \"g1\"," + 
		"\"wanted\" : \"w1\"," + 
		"\"id\" : \"1-" + this.getTestId() + "\"}]} ",
				com.anfelisa.card.data.CsvUploadData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpPut(
			"/category/import-csv", 
		 	payload_0,
			null,
			uuid
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: ImportCsv finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("ImportCsv", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 401) {
			String message = response.readEntity(String.class);
			assertFail(message);
		} else {
			LOG.info("THEN: status 401 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("ImportCsvUnauthorized")) {
			Response response = when();

			then(response);
			
			this.cardWasNoCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for ImportCsvUnauthorized not met");
		}
	}
	
	
	private void cardWasNoCreated() throws Exception {
		com.anfelisa.card.models.ICardModel actual = daoProvider.getCardDao().selectByCardId(handle, "1-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: cardWasNoCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ImportCsvUnauthorized";
	}
	
}



/******* S.D.G. *******/



