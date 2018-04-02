package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxModel.class)
public interface IBoxModel {

	String getBoxId();
	String getName();
	String getUsername();

}

/*       S.D.G.       */
