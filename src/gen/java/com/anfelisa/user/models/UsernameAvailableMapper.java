package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class UsernameAvailableMapper implements RowMapper<IUsernameAvailableModel> {
	
	public IUsernameAvailableModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UsernameAvailableModel(
			r.getString("username"),
			r.getBoolean("available")
		);
	}
}

/*       S.D.G.       */