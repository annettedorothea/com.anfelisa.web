/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class UsernameSearchMapper implements RowMapper<IUsernameSearchModel> {
	
	public IUsernameSearchModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UsernameSearchModel(
			r.getString("usernameSearchString"),
			r.getString("userId"),
			r.getString("categoryId"),
			null
		);
	}
}



/******* S.D.G. *******/


