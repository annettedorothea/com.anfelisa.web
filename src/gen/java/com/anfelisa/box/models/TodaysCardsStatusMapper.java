/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class TodaysCardsStatusMapper implements RowMapper<ITodaysCardsStatusModel> {
	
	public ITodaysCardsStatusModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new TodaysCardsStatusModel(
			r.getObject("openTodaysCards") != null ? r.getInt("openTodaysCards") : null,
			r.getObject("allTodaysCards") != null ? r.getInt("allTodaysCards") : null
		);
	}
}



/******* S.D.G. *******/



