/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
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




package com.anfelisa.box.getboxstatistics.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetBoxesWithOneScoredCardAndReinforceSameDayScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetBoxesWithOneScoredCardAndReinforceSameDayScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: RegisterUser uuid " + uuid);
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class),
						this.getProtocol(), this.getHost(), this.getPort());
			response = 
			com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"password\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.UserRegistrationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort());
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUser fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateBoxMinimal uuid " + uuid);
			response = 
			com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxMinimal fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}
		

		if (prerequisite("CreateCategory")) {
			uuid = "cat1-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateCategory uuid " + uuid);
			response = 
			com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 1 #1\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategory fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}
		

		if (prerequisite("CreateCard")) {
			uuid = "c1-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given\"," + 
					"\"image\" : \"image\"," + 
					"\"wanted\" : \"wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCard not met");
		}
		

		if (prerequisite("CreateSecondCard")) {
			uuid = "c2-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateSecondCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given2\"," + 
					"\"image\" : \"image2\"," + 
					"\"wanted\" : \"wanted2\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateSecondCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateSecondCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondCard not met");
		}
		

		if (prerequisite("CreateThirdCard")) {
			uuid = "c3-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateThirdCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"3given\"," + 
					"\"wanted\" : \"3wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateThirdCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateThirdCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateThirdCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateThirdCard not met");
		}
		

		if (prerequisite("CreateFourthCard")) {
			uuid = "c4-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateFourthCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"4given4\"," + 
					"\"wanted\" : \"4wanted4\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateFourthCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateFourthCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFourthCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateFourthCard not met");
		}
		

		if (prerequisite("CreateFifthCard")) {
			uuid = "c5-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateFifthCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"different\"," + 
					"\"wanted\" : \"different\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateFifthCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateFifthCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFifthCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateFifthCard not met");
		}
		

		if (prerequisite("ScheduleCards")) {
			uuid = "sc1-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: ScheduleCards uuid " + uuid);
			this.callNotReplayableDataProviderPutSystemTime(uuid, DateTime.parse("20200418 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC), 
						this.getProtocol(), this.getHost(), this.getPort());
			response = 
			com.anfelisa.box.ActionCalls.callScheduleCards(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
					"\"c3-" + this.getTestId() + "\"," + 
					"\"c4-" + this.getTestId() + "\"]} ",
			com.anfelisa.box.data.ScheduledCardsData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScheduleCards fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScheduleCards fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCards success");
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCards not met");
		}
		

		if (prerequisite("ScoreCard1")) {
			uuid = "score1-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: ScoreCard1 uuid " + uuid);
			this.callNotReplayableDataProviderPutSystemTime(uuid, DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC), 
						this.getProtocol(), this.getHost(), this.getPort());
			response = 
			com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 1," + 
					"\"scoredCardScheduledCardId\" : \"c3-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard1 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard1 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard1 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard1 not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		
		return 
		com.anfelisa.box.ActionCalls.callGetBoxStatistics(objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"todayAtMidnightInUTC\" : \"2020-04-18T00:00:00.000Z\"} ",
		com.anfelisa.box.data.BoxStatisticsListData.class)
		
		, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
		
	}
	
	private com.anfelisa.box.data.GetBoxStatisticsResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		
		com.anfelisa.box.data.GetBoxStatisticsResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.box.data.GetBoxStatisticsResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.box.data.BoxStatisticsListData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"\"," + 
				"\"boxList\" : [ { \"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"maxCardsPerDay\" : 10," + 
				"\"quality0Count\" : 0," + 
				"\"quality1Count\" : 1," + 
				"\"quality2Count\" : 0," + 
				"\"quality3Count\" : 0," + 
				"\"quality4Count\" : 0," + 
				"\"quality5Count\" : 0," + 
				"\"countsPerDayNextWeek\" : [ 1," + 
				"0," + 
				"0," + 
				"0," + 
				"0," + 
				"0," + 
				"0]}]} ",
		com.anfelisa.box.data.BoxStatisticsListData.class)
		
		;
		
		com.anfelisa.box.data.GetBoxStatisticsResponse expected = new com.anfelisa.box.data.GetBoxStatisticsResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getBoxesWithOneScoredCardAndReinforceSameDay() throws Exception {
					given();
						
					if (prerequisite("GetBoxesWithOneScoredCardAndReinforceSameDay")) {
						Response response = when();
		
						LOG.info("WHEN: GetBoxStatistics");
				
						com.anfelisa.box.data.GetBoxStatisticsResponse actualResponse = then(response);
						
						verifications(actualResponse);
					} else {
						LOG.info("prerequisite for GetBoxesWithOneScoredCardAndReinforceSameDay not met");
					}
				}
				
				protected abstract void verifications(com.anfelisa.box.data.GetBoxStatisticsResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetBoxesWithOneScoredCardAndReinforceSameDay";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			