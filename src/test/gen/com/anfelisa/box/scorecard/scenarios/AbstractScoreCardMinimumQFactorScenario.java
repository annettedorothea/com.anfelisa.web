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
public abstract class AbstractScoreCardMinimumQFactorScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser0 = new com.anfelisa.user.data.UserRegistrationData("uuid");
		registerUser0.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", 0));
		registerUser0.setLanguage(this.templateStringValue("de", 0));
		registerUser0.setPassword(this.templateStringValue("password", 0));
		registerUser0.setUsername(this.templateStringValue("Annette", 0));
		registerUser0.setToken(this.templateStringValue("TOKEN", 0));
		
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser0, DROPWIZARD.getLocalPort());
		

		com.anfelisa.box.data.BoxCreationData createBox1 = new com.anfelisa.box.data.BoxCreationData("boxId");
		createBox1.setCategoryName(this.templateStringValue("cat", 1));
		createBox1.setDictionaryLookup(new Boolean("false"));
		createBox1.setMaxCardsPerDay(1);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox1, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory2 = new com.anfelisa.category.data.CategoryCreationData("cat1");
		createCategory2.setCategoryName(this.templateStringValue("level 1 #1", 2));
		createCategory2.setParentCategoryId(this.templateStringValue("boxId", 2));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory2, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard3 = new com.anfelisa.card.data.CardCreationData("c1");
		createCard3.setCategoryId(this.templateStringValue("cat1", 3));
		createCard3.setGiven(this.templateStringValue("given", 3));
		createCard3.setImage(this.templateStringValue("image", 3));
		createCard3.setWanted(this.templateStringValue("wanted", 3));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard3, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard4 = new com.anfelisa.card.data.CardCreationData("c2");
		createCard4.setCategoryId(this.templateStringValue("cat1", 4));
		createCard4.setGiven(this.templateStringValue("given2", 4));
		createCard4.setImage(this.templateStringValue("image2", 4));
		createCard4.setWanted(this.templateStringValue("wanted2", 4));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard4, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard5 = new com.anfelisa.card.data.CardCreationData("c3");
		createCard5.setCategoryId(this.templateStringValue("cat1", 5));
		createCard5.setGiven(this.templateStringValue("3given", 5));
		createCard5.setWanted(this.templateStringValue("3wanted", 5));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard5, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard6 = new com.anfelisa.card.data.CardCreationData("c4");
		createCard6.setCategoryId(this.templateStringValue("cat1", 6));
		createCard6.setGiven(this.templateStringValue("4given4", 6));
		createCard6.setWanted(this.templateStringValue("4wanted4", 6));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard6, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard7 = new com.anfelisa.card.data.CardCreationData("c5");
		createCard7.setCategoryId(this.templateStringValue("cat1", 7));
		createCard7.setGiven(this.templateStringValue("different", 7));
		createCard7.setWanted(this.templateStringValue("different", 7));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard7, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200416 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScheduledCardsData scheduleCards8 = new com.anfelisa.box.data.ScheduledCardsData("sc1");
		
			List<String> scheduleCards8CardIds = new ArrayList<String>();
			scheduleCards8CardIds.add("c1");
		
			scheduleCards8CardIds.add("c3");
		
			scheduleCards8CardIds.add("c4");
		
			
		scheduleCards8.setCardIds(scheduleCards8CardIds);
		
		
		com.anfelisa.box.ActionCalls.callScheduleCards(scheduleCards8, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard9 = new com.anfelisa.box.data.ScoreCardData("score3");
		scoreCard9.setBoxId(this.templateStringValue("boxId", 9));
		scoreCard9.setScoredCardQuality(3);
		scoreCard9.setScoredCardScheduledCardId(this.templateStringValue("c1-sc1", 9));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard9, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.box.data.BoxCreationData createBox10 = new com.anfelisa.box.data.BoxCreationData("boxId");
		createBox10.setCategoryName(this.templateStringValue("cat", 10));
		createBox10.setDictionaryLookup(new Boolean("false"));
		createBox10.setMaxCardsPerDay(1);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox10, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.box.data.BoxUpdateData updateBox11 = new com.anfelisa.box.data.BoxUpdateData(randomUUID());
		updateBox11.setBoxId(this.templateStringValue("boxId", 11));
		updateBox11.setCategoryId(this.templateStringValue("boxId", 11));
		updateBox11.setCategoryName(this.templateStringValue("changed", 11));
		updateBox11.setDictionaryLookup(new Boolean("false"));
		updateBox11.setMaxCardsPerDay(11);
		updateBox11.setMaxInterval(90);
		
		
		com.anfelisa.box.ActionCalls.callUpdateBox(updateBox11, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200425 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard12 = new com.anfelisa.box.data.ScoreCardData("score31");
		scoreCard12.setBoxId(this.templateStringValue("boxId", 12));
		scoreCard12.setScoredCardQuality(3);
		scoreCard12.setScoredCardScheduledCardId(this.templateStringValue("score3", 12));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard12, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200515 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard13 = new com.anfelisa.box.data.ScoreCardData("score32");
		scoreCard13.setBoxId(this.templateStringValue("boxId", 13));
		scoreCard13.setScoredCardQuality(3);
		scoreCard13.setScoredCardScheduledCardId(this.templateStringValue("score31", 13));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard13, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200615 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard14 = new com.anfelisa.box.data.ScoreCardData("score33");
		scoreCard14.setBoxId(this.templateStringValue("boxId", 14));
		scoreCard14.setScoredCardQuality(4);
		scoreCard14.setScoredCardScheduledCardId(this.templateStringValue("score32", 14));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard14, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200819 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard15 = new com.anfelisa.box.data.ScoreCardData("score34");
		scoreCard15.setBoxId(this.templateStringValue("boxId", 15));
		scoreCard15.setScoredCardQuality(5);
		scoreCard15.setScoredCardScheduledCardId(this.templateStringValue("score33", 15));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard15, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20201120 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard16 = new com.anfelisa.box.data.ScoreCardData("score35");
		scoreCard16.setBoxId(this.templateStringValue("boxId", 16));
		scoreCard16.setScoredCardQuality(3);
		scoreCard16.setScoredCardScheduledCardId(this.templateStringValue("score34", 16));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard16, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20210301 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard17 = new com.anfelisa.box.data.ScoreCardData("score36");
		scoreCard17.setBoxId(this.templateStringValue("boxId", 17));
		scoreCard17.setScoredCardQuality(3);
		scoreCard17.setScoredCardScheduledCardId(this.templateStringValue("score35", 17));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard17, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20210701 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard18 = new com.anfelisa.box.data.ScoreCardData("score37");
		scoreCard18.setBoxId(this.templateStringValue("boxId", 18));
		scoreCard18.setScoredCardQuality(3);
		scoreCard18.setScoredCardScheduledCardId(this.templateStringValue("score36", 18));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard18, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20211001 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard19 = new com.anfelisa.box.data.ScoreCardData("score38");
		scoreCard19.setBoxId(this.templateStringValue("boxId", 19));
		scoreCard19.setScoredCardQuality(3);
		scoreCard19.setScoredCardScheduledCardId(this.templateStringValue("score37", 19));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard19, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20220201 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard20 = new com.anfelisa.box.data.ScoreCardData("score39");
		scoreCard20.setBoxId(this.templateStringValue("boxId", 20));
		scoreCard20.setScoredCardQuality(3);
		scoreCard20.setScoredCardScheduledCardId(this.templateStringValue("score38", 20));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard20, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20220601 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard21 = new com.anfelisa.box.data.ScoreCardData("score310");
		scoreCard21.setBoxId(this.templateStringValue("boxId", 21));
		scoreCard21.setScoredCardQuality(3);
		scoreCard21.setScoredCardScheduledCardId(this.templateStringValue("score39", 21));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard21, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		NotReplayableDataProvider.setSystemTime(DateTime.parse("20221001 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard0 = new com.anfelisa.box.data.ScoreCardData("q");
		scoreCard0.setBoxId(this.templateStringValue("boxId", 0));
		scoreCard0.setScoredCardQuality(3);
		scoreCard0.setScoredCardScheduledCardId(this.templateStringValue("score310", 0));
		
		
		return 
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void scoreCardMinimumQFactor() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			
