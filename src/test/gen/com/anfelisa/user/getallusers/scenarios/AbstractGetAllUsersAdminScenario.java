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




package com.anfelisa.user.getallusers.scenarios;

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
public abstract class AbstractGetAllUsersAdminScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("ADMIN-TOKEN", null));
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid-admin", this.templateStringValue("admin-password", 0), this.templateStringValue("Admin", 0), this.templateStringValue("annette.pohl@anfelisa.de", 0), this.templateStringValue("de", 0), DROPWIZARD.getLocalPort());

		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", this.templateStringValue("password", 1), this.templateStringValue("Annette", 1), this.templateStringValue("annette.pohl@anfelisa.de", 1), this.templateStringValue("de", 1), DROPWIZARD.getLocalPort());

		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.ActionCalls.callConfirmEmail(randomUUID(), this.templateStringValue("TOKEN", 2), this.templateStringValue("Annette", 2), DROPWIZARD.getLocalPort());

	}
	
	private Response when() throws Exception {
		return com.anfelisa.user.ActionCalls.callGetAllUsers(randomUUID(), DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
	}
	
	private com.anfelisa.user.data.GetAllUsersResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.user.data.GetAllUsersResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.GetAllUsersResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.user.data.UserListData expectedData = new com.anfelisa.user.data.UserListData(randomUUID());
		
			List<com.anfelisa.user.models.IUserModel> expectedDataUserList = new ArrayList<com.anfelisa.user.models.IUserModel>();
			com.anfelisa.user.models.IUserModel item1 = new com.anfelisa.user.models.UserModel();
			item1.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", null));
			item1.setPassword(this.templateStringValue("admin-password", null));
			item1.setUsername(this.templateStringValue("Admin", null));
			item1.setUserId(this.templateStringValue("uuid-admin", null));
			item1.setEmailConfirmed(new Boolean("False"));
			item1.setRole(this.templateStringValue("ADMIN", null));
			expectedDataUserList.add(item1);
		
			com.anfelisa.user.models.IUserModel item2 = new com.anfelisa.user.models.UserModel();
			item2.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", null));
			item2.setPassword(this.templateStringValue("password", null));
			item2.setUsername(this.templateStringValue("Annette", null));
			item2.setEmailConfirmed(new Boolean("True"));
			item2.setRole(this.templateStringValue("STUDENT", null));
			item2.setUserId(this.templateStringValue("uuid", null));
			expectedDataUserList.add(item2);
		
			
		expectedData.setUserList(expectedDataUserList);
		
		com.anfelisa.user.data.GetAllUsersResponse expected = new com.anfelisa.user.data.GetAllUsersResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getAllUsersAdmin() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.user.data.GetAllUsersResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.user.data.GetAllUsersResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			
