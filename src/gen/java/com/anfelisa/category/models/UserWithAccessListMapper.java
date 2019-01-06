package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class UserWithAccessListMapper implements RowMapper<IUserWithAccessListModel> {
	
	public IUserWithAccessListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserWithAccessListModel(
			r.getString("categoryId"),
			null
		);
	}
}

/*       S.D.G.       */