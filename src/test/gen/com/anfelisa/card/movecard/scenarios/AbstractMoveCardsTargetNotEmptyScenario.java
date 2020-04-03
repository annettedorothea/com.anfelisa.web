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




package com.anfelisa.card.movecard.scenarios;

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
public abstract class AbstractMoveCardsTargetNotEmptyScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", this.templateStringValue("password", 0), this.templateStringValue("Annette", 0), this.templateStringValue("annette.pohl@anfelisa.de", 0), this.templateStringValue("de", 0), DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", this.templateStringValue("cat", 1), new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", this.templateStringValue("level 1 #1", 2), this.templateStringValue("boxId", 2), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c1", this.templateStringValue("wanted", 3), this.templateStringValue("given", 3), this.templateStringValue("image", 3), this.templateStringValue("cat1", 3), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c2", this.templateStringValue("wanted2", 4), this.templateStringValue("given2", 4), this.templateStringValue("image2", 4), this.templateStringValue("cat1", 4), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c3", this.templateStringValue("3wanted", 5), this.templateStringValue("3given", 5), null, this.templateStringValue("cat1", 5), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c4", this.templateStringValue("4wanted4", 6), this.templateStringValue("4given4", 6), null, this.templateStringValue("cat1", 6), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c5", this.templateStringValue("different", 7), this.templateStringValue("different", 7), null, this.templateStringValue("cat1", 7), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", this.templateStringValue("level 1 #1", 8), this.templateStringValue("boxId", 8), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat2", this.templateStringValue("level 1 #2", 9), this.templateStringValue("boxId", 9), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat2", this.templateStringValue("level 1 #2", 10), this.templateStringValue("boxId", 10), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c6", this.templateStringValue("zz-wanted", 11), this.templateStringValue("aa-given", 11), null, this.templateStringValue("cat2", 11), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		return com.anfelisa.card.ActionCalls.callMoveCards(randomUUID(), new ArrayList<>(Arrays.asList(new String[] { "c1", "c2", "c4" })), 
		this.templateStringValue("cat2", 0), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void moveCardsTargetNotEmpty() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			
