/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CardListMapper implements RowMapper<ICardListModel> {
	
	public ICardListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardListModel(
			r.getString("userId"),
			null,
			r.getString("categoryId"),
			r.getBoolean("filterNonScheduled"),
			r.getObject("priority") != null ? r.getInt("priority") : null,
			r.getBoolean("reverse")
		);
	}
}



/******* S.D.G. *******/



