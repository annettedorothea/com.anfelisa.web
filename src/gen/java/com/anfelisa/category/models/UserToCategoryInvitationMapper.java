/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class UserToCategoryInvitationMapper implements RowMapper<IUserToCategoryInvitationModel> {
	
	public IUserToCategoryInvitationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserToCategoryInvitationModel(
			r.getString("categoryId"),
			r.getString("userId"),
			r.getString("invitedUsername"),
			r.getString("invitedUserId"),
			null
		);
	}
}



/******* S.D.G. *******/



