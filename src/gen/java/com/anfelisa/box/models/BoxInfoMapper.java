package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class BoxInfoMapper implements ResultSetMapper<IBoxInfoModel> {
	
	public IBoxInfoModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxInfoModel(
			r.getInt("todaysCards"),
			null
		);
	}
}

/*       S.D.G.       */
