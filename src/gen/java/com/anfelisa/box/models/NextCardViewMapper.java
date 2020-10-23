/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class NextCardViewMapper implements RowMapper<INextCardViewModel> {
	
	public INextCardViewModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new NextCardViewModel(
			r.getString("scheduledCardId"),
			r.getString("reinforceCardId"),
			r.getString("cardId"),
			r.getTimestamp("scheduledDate") != null ? r.getTimestamp("scheduledDate").toLocalDateTime() : null,
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getObject("count") != null ? r.getInt("count") : null,
			r.getTimestamp("scoredDate") != null ? r.getTimestamp("scoredDate").toLocalDateTime() : null
		);
	}
}



/******* S.D.G. *******/



