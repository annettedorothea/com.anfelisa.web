package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=StudentOfCourseModel.class)
public interface IStudentOfCourseModel {

	String getUsername();
	Integer getCourseId();


}

/*       S.D.G.       */
