package com.anfelisa.lesson.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=LessonAbstractModel.class)
public interface ILessonAbstractModel {

	String getLessonName();
	String getLessonDescription();
	String getLessonAuthor();
	Integer getLessonId();


}

/*       S.D.G.       */
