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




package com.anfelisa.box.scorecard.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractScoreCard38Scenario extends BaseScenario {

	private void given() throws Exception {
		Response response;
		NotReplayableDataProvider.put("token", objectMapper.readValue("\"TOKEN\"",
				 String.class));
		response = 
		com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
			"\"uuid\" : \"uuid\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette\"," + 
				"\"token\" : \"TOKEN\"} ",
		com.anfelisa.user.data.UserRegistrationData.class)
		
		, DROPWIZARD.getLocalPort());
		
		if (response.getStatus() == 500) {
			String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
			"\"uuid\" : \"boxId\"," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateBox fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
			"\"uuid\" : \"cat1\"," + 
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c1\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"wanted\" : \"wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c2\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given2\"," + 
				"\"image\" : \"image2\"," + 
				"\"wanted\" : \"wanted2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c3\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"3given\"," + 
				"\"wanted\" : \"3wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c4\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4given4\"," + 
				"\"wanted\" : \"4wanted4\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c5\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"different\"," + 
				"\"wanted\" : \"different\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScheduleCards(objectMapper.readValue("{" +
			"\"uuid\" : \"sc1\"," + 
				"\"cardIds\" : [ \"c1\"," + 
				"\"c3\"," + 
				"\"c4\"]} ",
		com.anfelisa.box.data.ScheduledCardsData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScheduleCards fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score3\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 3," + 
				"\"scoredCardScheduledCardId\" : \"c1-sc1\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.box.ActionCalls.callUpdateBox(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"categoryId\" : \"boxId\"," + 
				"\"categoryName\" : \"changed\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 11," + 
				"\"maxInterval\" : 90} ",
		com.anfelisa.box.data.BoxUpdateData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN UpdateBox fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200425 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score31\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 3," + 
				"\"scoredCardScheduledCardId\" : \"score3\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200515 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score32\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 3," + 
				"\"scoredCardScheduledCardId\" : \"score31\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200615 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score33\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 4," + 
				"\"scoredCardScheduledCardId\" : \"score32\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200819 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score34\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 5," + 
				"\"scoredCardScheduledCardId\" : \"score33\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20201120 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score35\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 3," + 
				"\"scoredCardScheduledCardId\" : \"score34\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20210301 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score36\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 3," + 
				"\"scoredCardScheduledCardId\" : \"score35\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20210701 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score37\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 3," + 
				"\"scoredCardScheduledCardId\" : \"score36\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

	}
	
	private Response when() throws Exception {
		NotReplayableDataProvider.setSystemTime(DateTime.parse("20211001 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		
		return 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score38\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 3," + 
				"\"scoredCardScheduledCardId\" : \"score37\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void scoreCard38() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
				}
				
				protected abstract void verifications();
				
				@Override
				protected String scenarioName() {
					return "ScoreCard38";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			