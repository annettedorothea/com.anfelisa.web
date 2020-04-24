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




package com.anfelisa.box.getboxsettings.scenarios;

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
public abstract class AbstractGetBoxSettingsNoBoxIdScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", objectMapper.readValue("\"TOKEN\"",
				 String.class));
		
		com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
			"\"uuid\" : \"uuid\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette\"," + 
				"\"token\" : \"TOKEN\"} ",
		com.anfelisa.user.data.UserRegistrationData.class)
		
		, DROPWIZARD.getLocalPort());
		

		
		com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
			"\"uuid\" : \"boxId\"," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 1} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.box.ActionCalls.callGetBoxSettings(objectMapper.readValue("{" +
			"\"uuid\" : \"2ae616a1-f29b-4d06-af29-2a2b42a7b30c\"} ",
		com.anfelisa.box.data.BoxSettingsWrapperData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private com.anfelisa.box.data.GetBoxSettingsResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 400);
		
		com.anfelisa.box.data.GetBoxSettingsResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.box.data.GetBoxSettingsResponse.class);
		} catch (Exception x) {
		}
			
			return actual;
				}
				
				@Test
				public void getBoxSettingsNoBoxId() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.box.data.GetBoxSettingsResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.box.data.GetBoxSettingsResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			
