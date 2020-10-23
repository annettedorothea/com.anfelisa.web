/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class SimpleCardMapper implements RowMapper<ISimpleCardModel> {
	
	public ISimpleCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new SimpleCardModel(
			r.getString("given"),
			r.getString("wanted"),
			r.getString("id")
		);
	}
}



/******* S.D.G. *******/



