package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class NextReinforceCardMapper implements RowMapper<INextReinforceCardModel> {
	
	public INextReinforceCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new NextReinforceCardModel(
			r.getString("reinforceCardId"),
			r.getTimestamp("changeDate") != null ? new org.joda.time.DateTime(r.getTimestamp("changeDate")) : null,
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("categoryId")
		);
	}
}

/*       S.D.G.       */
