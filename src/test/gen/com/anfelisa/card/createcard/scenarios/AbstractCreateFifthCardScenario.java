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




package com.anfelisa.card.createcard.scenarios;

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
public abstract class AbstractCreateFifthCardScenario extends BaseScenario {

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
		createBox1.setMaxCardsPerDay(10);
		
		
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
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.card.data.CardCreationData createCard0 = new com.anfelisa.card.data.CardCreationData("c5");
		createCard0.setCategoryId(this.templateStringValue("cat1", 0));
		createCard0.setGiven(this.templateStringValue("different", 0));
		createCard0.setWanted(this.templateStringValue("different", 0));
		
		
		return 
		com.anfelisa.card.ActionCalls.callCreateCard(createCard0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void createFifthCard() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			
