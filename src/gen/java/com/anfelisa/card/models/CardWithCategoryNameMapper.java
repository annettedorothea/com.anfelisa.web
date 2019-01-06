package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CardWithCategoryNameMapper implements RowMapper<ICardWithCategoryNameModel> {
	
	public ICardWithCategoryNameModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardWithCategoryNameModel(
			r.getString("categoryName"),
			r.getString("cardId"),
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("cardAuthor"),
			r.getObject("cardIndex") != null ? r.getInt("cardIndex") : null,
			r.getString("categoryId"),
			r.getString("rootCategoryId")
		);
	}
}

/*       S.D.G.       */