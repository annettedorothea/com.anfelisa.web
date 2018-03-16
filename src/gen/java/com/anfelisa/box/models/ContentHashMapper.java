package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ContentHashMapper implements ResultSetMapper<IContentHashModel> {
	
	public IContentHashModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ContentHashModel(
			r.getString("contentHash")
		);
	}
}

/*       S.D.G.       */