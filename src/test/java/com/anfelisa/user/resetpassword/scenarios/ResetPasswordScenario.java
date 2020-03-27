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




package com.anfelisa.user.resetpassword.scenarios;

import javax.ws.rs.core.Response;

import com.anfelisa.auth.Roles;
import com.anfelisa.user.models.IResetPasswordModel;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserModel;

@SuppressWarnings("unused")
public class ResetPasswordScenario extends AbstractResetPasswordScenario {

	@Override
	protected void verifications() {
		IUserModel actualUser = this.daoProvider.getUserDao().selectByUsername(handle, "Annette");
		IUserModel expectedUser = new UserModel("uuid", "Annette", "newPassword", "annette.pohl@anfelisa.de", Roles.STUDENT, false);
		assertThat(actualUser, expectedUser);

		IResetPasswordModel actual = this.daoProvider.getResetPasswordDao().selectByToken(handle, "RESET-PW-TOKEN");
		assertIsNull(actual);
	}

}




/******* S.D.G. *******/


