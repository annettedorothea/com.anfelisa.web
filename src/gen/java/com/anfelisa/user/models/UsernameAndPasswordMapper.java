package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class UsernameAndPasswordMapper implements ResultSetMapper<IUsernameAndPasswordModel> {
	
	public IUsernameAndPasswordModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UsernameAndPasswordModel(
			r.getString("username"),
			r.getString("password")
		);
	}
}

/*       S.D.G.       */