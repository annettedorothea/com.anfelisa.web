package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=RoleModel.class)
public interface IRoleModel {

	String getRole();

}

/*       S.D.G.       */