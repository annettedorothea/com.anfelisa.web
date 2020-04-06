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




package com.anfelisa.card.getcards.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetCardsUnauthorizedScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser0 = new com.anfelisa.user.data.UserRegistrationData("uuid");
		registerUser0.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", null));
		registerUser0.setLanguage(this.templateStringValue("de", null));
		registerUser0.setPassword(this.templateStringValue("password", null));
		registerUser0.setUsername(this.templateStringValue("Annette", null));
		registerUser0.setToken(this.templateStringValue("TOKEN", null));
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser0, DROPWIZARD.getLocalPort());

		com.anfelisa.box.data.BoxCreationData createBox1 = new com.anfelisa.box.data.BoxCreationData("boxId");
		createBox1.setCategoryName(this.templateStringValue("cat", null));
		createBox1.setDictionaryLookup(new Boolean("false"));
		createBox1.setMaxCardsPerDay(10);
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox1, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.data.CategoryCreationData createCategory2 = new com.anfelisa.category.data.CategoryCreationData("cat1");
		createCategory2.setCategoryName(this.templateStringValue("level 1 #1", null));
		createCategory2.setParentCategoryId(this.templateStringValue("boxId", null));
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory2, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.data.CardCreationData createCard3 = new com.anfelisa.card.data.CardCreationData("c1");
		createCard3.setCategoryId(this.templateStringValue("cat1", null));
		createCard3.setGiven(this.templateStringValue("given", null));
		createCard3.setImage(this.templateStringValue("image", null));
		createCard3.setWanted(this.templateStringValue("wanted", null));
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard3, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.data.CardCreationData createCard4 = new com.anfelisa.card.data.CardCreationData("c2");
		createCard4.setCategoryId(this.templateStringValue("cat1", null));
		createCard4.setGiven(this.templateStringValue("given2", null));
		createCard4.setImage(this.templateStringValue("image2", null));
		createCard4.setWanted(this.templateStringValue("wanted2", null));
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard4, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.data.CardCreationData createCard5 = new com.anfelisa.card.data.CardCreationData("c3");
		createCard5.setCategoryId(this.templateStringValue("cat1", null));
		createCard5.setGiven(this.templateStringValue("3given", null));
		createCard5.setWanted(this.templateStringValue("3wanted", null));
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard5, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.data.CardCreationData createCard6 = new com.anfelisa.card.data.CardCreationData("c4");
		createCard6.setCategoryId(this.templateStringValue("cat1", null));
		createCard6.setGiven(this.templateStringValue("4given4", null));
		createCard6.setWanted(this.templateStringValue("4wanted4", null));
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard6, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.data.CardCreationData createCard7 = new com.anfelisa.card.data.CardCreationData("c5");
		createCard7.setCategoryId(this.templateStringValue("cat1", null));
		createCard7.setGiven(this.templateStringValue("different", null));
		createCard7.setWanted(this.templateStringValue("different", null));
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard7, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		com.anfelisa.card.data.CardListData getCards0 = new com.anfelisa.card.data.CardListData(randomUUID());
		getCards0.setCategoryId(this.templateStringValue("cat1", null));
		
		return 
		com.anfelisa.card.ActionCalls.callGetCards(getCards0, DROPWIZARD.getLocalPort(), null);
	}
	
	private com.anfelisa.card.data.GetCardsResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 401);
		
		com.anfelisa.card.data.GetCardsResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.card.data.GetCardsResponse.class);
		} catch (Exception x) {
		}
			
			return actual;
				}
				
				@Test
				public void getCardsUnauthorized() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.card.data.GetCardsResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.card.data.GetCardsResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			
