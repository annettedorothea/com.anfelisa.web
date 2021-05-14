/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ScoreReinforceCardMapper implements RowMapper<IScoreReinforceCardModel> {
	
	public IScoreReinforceCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreReinforceCardModel(
			r.getString("reinforceCardId"),
			r.getBoolean("keep"),
			r.getTimestamp("changeDate") != null ? r.getTimestamp("changeDate").toLocalDateTime() : null,
			r.getString("userId")
		);
	}
}



/******* S.D.G. *******/



