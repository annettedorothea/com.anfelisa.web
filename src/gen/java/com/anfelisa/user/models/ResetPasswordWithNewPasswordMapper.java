package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ResetPasswordWithNewPasswordMapper implements RowMapper<IResetPasswordWithNewPasswordModel> {
	
	public IResetPasswordWithNewPasswordModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ResetPasswordWithNewPasswordModel(
			r.getString("password"),
			r.getString("token"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */