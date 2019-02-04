package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ResetPasswordModel.class)
public interface IResetPasswordModel {

	String getToken();
	void setToken(String token);
	
	String getUserId();
	void setUserId(String userId);
	
	
	List<String> equalsPrimitiveTypes(IResetPasswordModel other);
	
}

/*       S.D.G.       */
