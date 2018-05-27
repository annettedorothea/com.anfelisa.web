package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=DeleteBoxModel.class)
public interface IDeleteBoxModel {

	String getUserId();
	String getBoxId();

}

/*       S.D.G.       */
