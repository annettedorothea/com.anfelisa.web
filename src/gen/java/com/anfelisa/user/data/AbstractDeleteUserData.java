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




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IDeleteUserModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractDeleteUserData extends AbstractData implements IDeleteUserData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteUserData.class);
	
	@NotNull
	private String usernameToBeDeleted;
	
	@NotNull
	private String username;
	
	@NotNull
	private String role;
	

	public AbstractDeleteUserData(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted,
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.usernameToBeDeleted = usernameToBeDeleted;
		this.username = username;
		this.role = role;
	}

	public AbstractDeleteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public String getUsernameToBeDeleted() {
			return this.usernameToBeDeleted;
		}
	public void setUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
	}
	public IDeleteUserData withUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
		return this;
	}
	
	@JsonProperty
		public String getUsername() {
			return this.username;
		}
	public void setUsername(String username) {
		this.username = username;
	}
	public IDeleteUserData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
		public String getRole() {
			return this.role;
		}
	public void setRole(String role) {
		this.role = role;
	}
	public IDeleteUserData withRole(String role) {
		this.role = role;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



