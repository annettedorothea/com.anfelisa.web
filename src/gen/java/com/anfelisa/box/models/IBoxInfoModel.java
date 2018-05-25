package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxInfoModel.class)
public interface IBoxInfoModel {

	Integer getTodaysCards();
	com.anfelisa.box.models.IBoxModel getBox();

}

/*       S.D.G.       */
