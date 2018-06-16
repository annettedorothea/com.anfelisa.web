package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IDeleteBoxModel;

@JsonDeserialize(as=DeleteBoxData.class)
public interface IDeleteBoxData extends IDeleteBoxModel, IDataContainer {

}

/*       S.D.G.       */
