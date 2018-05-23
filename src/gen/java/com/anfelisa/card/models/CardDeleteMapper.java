package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CardDeleteMapper implements ResultSetMapper<ICardDeleteModel> {
	
	public ICardDeleteModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardDeleteModel(
			r.getString("cardId"),
			r.getInt("cardIndex"),
			r.getString("categoryId")
		);
	}
}

/*       S.D.G.       */
