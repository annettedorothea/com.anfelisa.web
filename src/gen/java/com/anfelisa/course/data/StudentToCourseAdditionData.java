package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IStudentOfCourseModel;

@SuppressWarnings("unused")
public class StudentToCourseAdditionData implements IStudentToCourseAdditionData {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private String username;
	
	@NotNull
	private Integer courseId;
	

	

	public StudentToCourseAdditionData(
		@JsonProperty("username") String username,
		@JsonProperty("courseId") Integer courseId
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.username = username;
		this.courseId = courseId;
		this.uuid = uuid;
		this.schema = schema;
	}

	public StudentToCourseAdditionData( String uuid,	String schema ) {
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
	public StudentToCourseAdditionData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public StudentToCourseAdditionData withCourseId(Integer courseId) {
		this.courseId = courseId;
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
