package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ScoreCardMapper implements ResultSetMapper<IScoreCardModel> {
	
	public IScoreCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreCardModel(
			r.getString("scheduledCardId"),
			r.getTimestamp("createdDate") != null ? new org.joda.time.DateTime(r.getTimestamp("createdDate")) : null,
			r.getFloat("ef"),
			r.getObject("interval") != null ? r.getInt("interval") : null,
			r.getObject("n") != null ? r.getInt("n") : null,
			r.getObject("count") != null ? r.getInt("count") : null,
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null,
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getObject("quality") != null ? r.getInt("quality") : null,
			r.getTimestamp("scoredDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scoredDate")) : null,
			r.getBoolean("removed")
		);
	}
}

/*       S.D.G.       */