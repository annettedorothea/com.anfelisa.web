package com.anfelisa.result.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ResultIdMapper implements ResultSetMapper<IResultIdModel> {
	
	public IResultIdModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ResultIdModel(
			r.getString("resultId")
		);
	}
}

/*       S.D.G.       */
