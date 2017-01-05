package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.user.models.IAvailableModel;

@SuppressWarnings("unused")
public class UsernameAvailableData implements IUsernameAvailableData {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private String username;
	
	private Boolean available;
	

	
	

	public UsernameAvailableData(
		@JsonProperty("username") String username,
		@JsonProperty("available") Boolean available
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.username = username;
		this.available = available;
		this.uuid = uuid;
		this.schema = schema;
	}

	public UsernameAvailableData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UsernameAvailableData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public UsernameAvailableData withAvailable(Boolean available) {
		this.available = available;
		return this;
	}
	
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */