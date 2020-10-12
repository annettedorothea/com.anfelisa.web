/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class BoxStatisticsMapper implements RowMapper<IBoxStatisticsModel> {
	
	public IBoxStatisticsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxStatisticsModel(
			r.getString("boxId"),
			r.getObject("quality0Count") != null ? r.getInt("quality0Count") : null,
			r.getObject("quality1Count") != null ? r.getInt("quality1Count") : null,
			r.getObject("quality2Count") != null ? r.getInt("quality2Count") : null,
			r.getObject("quality3Count") != null ? r.getInt("quality3Count") : null,
			r.getObject("quality4Count") != null ? r.getInt("quality4Count") : null,
			r.getObject("quality5Count") != null ? r.getInt("quality5Count") : null,
			null,
			r.getObject("maxCardsPerDay") != null ? r.getInt("maxCardsPerDay") : null
		);
	}
}



/******* S.D.G. *******/



