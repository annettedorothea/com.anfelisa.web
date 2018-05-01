package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class FillBoxMapper implements ResultSetMapper<IFillBoxModel> {
	
	public IFillBoxModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new FillBoxModel(
			r.getString("boxId"),
			null
		);
	}
}

/*       S.D.G.       */
