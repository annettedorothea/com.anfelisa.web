package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseListModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("unused")
public class CourseSelectionData implements ICourseListModel, IUsernameModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private String username;
	

	private java.util.List<com.anfelisa.course.models.ICourseModel> courseList;
	
	

	public CourseSelectionData(
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.username = username;
		this.uuid = uuid;
		this.schema = schema;
	}

	public CourseSelectionData( String uuid,	String schema ) {
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
	public CourseSelectionData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.course.models.ICourseModel> getCourseList() {
		return this.courseList;
	}
	public void setCourseList(java.util.List<com.anfelisa.course.models.ICourseModel> courseList) {
		this.courseList = courseList;
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