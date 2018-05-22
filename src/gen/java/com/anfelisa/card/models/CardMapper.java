package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CardMapper implements ResultSetMapper<ICardModel> {
	
	public ICardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardModel(
			r.getString("cardId"),
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("cardAuthor"),
			r.getInt("cardIndex"),
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getString("path")
		);
	}
}

/*       S.D.G.       */
