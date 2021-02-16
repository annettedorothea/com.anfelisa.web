/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.schedulecards.scenarios;

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
public abstract class AbstractScheduleCardsAsAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractScheduleCardsAsAdminScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callNonDeterministicDataProviderPutValue(uuid, "token",	"ADMIN-TOKEN");
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
				String message = "GIVEN RegisterUserAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

		if (prerequisite("CreateBoxMinimalAsAdmin")) {
			uuid = "adminBox-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String statusMessage = response_1.getStatusMessage() != null ? response_1.getStatusMessage() : "";
				String message = "GIVEN CreateBoxMinimalAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxMinimalAsAdmin fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimalAsAdmin success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimalAsAdmin not met");
		}

		if (prerequisite("CreateCategoryAsAdmin")) {
			uuid = "adminCat-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"c\"," + 
				"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"c\"," + 
			"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/category/create", 
			 	payload_2,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String statusMessage = response_2.getStatusMessage() != null ? response_2.getStatusMessage() : "";
				String message = "GIVEN CreateCategoryAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCategoryAsAdmin fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategoryAsAdmin success in {} ms", response_2.getDuration());
			addToMetrics("CreateCategory", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategoryAsAdmin not met");
		}

		if (prerequisite("CreateCardAsAdmin")) {
			uuid = "c6-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_3 = objectMapper.readValue("{" +
				"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_3 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"image\" : \"image\"," + 
			"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_3 = 
			this.httpPost(
				"/card/create", 
			 	payload_3,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_3.getStatusCode() >= 400) {
				String statusMessage = response_3.getStatusMessage() != null ? response_3.getStatusMessage() : "";
				String message = "GIVEN CreateCardAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCardAsAdmin fails due to {} in {} ms", message, response_3.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCardAsAdmin success in {} ms", response_3.getDuration());
			addToMetrics("CreateCard", response_3.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCardAsAdmin not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "sc6-" + this.getTestId() + "";
		this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
		com.anfelisa.box.data.ScheduleCardsPayload payload_0 = objectMapper.readValue("{" +
			"\"cardIds\" : [ \"c6-" + this.getTestId() + "\"]," + 
			"\"boxId\" : \"adminBox-" + this.getTestId() + "\"} ",
				com.anfelisa.box.data.ScheduleCardsPayload.class);
		com.anfelisa.box.data.ScheduledCardsData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"cardIds\" : [ \"c6-" + this.getTestId() + "\"]," + 
		"\"boxId\" : \"adminBox-" + this.getTestId() + "\"} ",
				com.anfelisa.box.data.ScheduledCardsData.class);
		HttpResponse<Object> response = 
		this.httpPost(
			"/cards/schedule", 
		 	payload_0,
			authorization("Admin", "admin-password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: ScheduleCards finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("ScheduleCards", response.getDuration());
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
			
		if (prerequisite("ScheduleCardsAsAdmin")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.cardWasScheduled();
	
		} else {
			LOG.info("WHEN: prerequisite for ScheduleCardsAsAdmin not met");
		}
	}
	
	
	private void cardWasScheduled() throws Exception {
		com.anfelisa.box.models.IScheduledCardModel actual = daoProvider.getScheduledCardDao().selectByScheduledCardId(handle, "c6-" + this.getTestId() + "-sc6-" + this.getTestId() + "");
		
		com.anfelisa.box.models.IScheduledCardModel expected = objectMapper.readValue("{" +
			"\"boxId\" : \"adminBox-" + this.getTestId() + "\"," + 
			"\"cardId\" : \"c6-" + this.getTestId() + "\"," + 
			"\"count\" : 0," + 
			"\"createdDate\" : \"2020-04-18T10:30\"," + 
			"\"ef\" : \"2.5F\"," + 
			"\"interval\" : 1," + 
			"\"lastQuality\" : null," + 
			"\"n\" : 1," + 
			"\"quality\" : null," + 
			"\"scheduledCardId\" : \"c6-" + this.getTestId() + "-sc6-" + this.getTestId() + "\"," + 
			"\"scheduledDate\" : \"2020-04-18T10:30\"," + 
			"\"scoredDate\" : null} ",
		com.anfelisa.box.models.ScheduledCardModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: cardWasScheduled passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ScheduleCardsAsAdmin";
	}
	
}



/******* S.D.G. *******/



