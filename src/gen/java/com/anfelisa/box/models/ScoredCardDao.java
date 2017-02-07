package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class ScoredCardDao {
	
	public void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".scoredcard (scoredCardId serial NOT NULL  , cardId integer NOT NULL  , scheduledDateOfScored timestamp with time zone  , boxId integer NOT NULL  , quality integer  , timestamp timestamp with time zone NOT NULL  , points integer  , scheduledCardId integer NOT NULL  , CONSTRAINT scoredcard_pkey PRIMARY KEY (scoredCardId), CONSTRAINT scoredcard_cardId_fkey FOREIGN KEY (cardId) REFERENCES " + schema + ".card ( cardId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT scoredcard_boxId_fkey FOREIGN KEY (boxId) REFERENCES " + schema + ".box ( boxId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT scoredcard_scheduledCardId_fkey FOREIGN KEY (scheduledCardId) REFERENCES " + schema + ".scheduledcard ( scheduledCardId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT scoredcard_scoredCardId_unique UNIQUE (scoredCardId))");
	}
	
	public Integer insert(Handle handle, IScoredCardModel scoredCardModel, String schema) {
		if (scoredCardModel.getScoredCardId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".scoredcard (scoredCardId, cardId, scheduledDateOfScored, boxId, quality, timestamp, points, scheduledCardId) VALUES (:scoredCardId, :cardId, :scheduledDateOfScored, :boxId, :quality, :timestamp, :points, :scheduledCardId)");
			statement.bind("scoredCardId", scoredCardModel.getScoredCardId());
			statement.bind("cardId", scoredCardModel.getCardId());
			statement.bind("scheduledDateOfScored", scoredCardModel.getScheduledDateOfScored());
			statement.bind("boxId", scoredCardModel.getBoxId());
			statement.bind("quality", scoredCardModel.getQuality());
			statement.bind("timestamp", scoredCardModel.getTimestamp());
			statement.bind("points", scoredCardModel.getPoints());
			statement.bind("scheduledCardId", scoredCardModel.getScheduledCardId());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".scoredcard_scoredCardId_seq', (SELECT MAX(scoredCardId) FROM " + schema + ".scoredcard));").execute();
			return scoredCardModel.getScoredCardId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO " + schema + ".scoredcard (cardId, scheduledDateOfScored, boxId, quality, timestamp, points, scheduledCardId) VALUES (:cardId, :scheduledDateOfScored, :boxId, :quality, :timestamp, :points, :scheduledCardId) RETURNING scoredCardId");
			statement.bind("cardId", scoredCardModel.getCardId());
			statement.bind("scheduledDateOfScored", scoredCardModel.getScheduledDateOfScored());
			statement.bind("boxId", scoredCardModel.getBoxId());
			statement.bind("quality", scoredCardModel.getQuality());
			statement.bind("timestamp", scoredCardModel.getTimestamp());
			statement.bind("points", scoredCardModel.getPoints());
			statement.bind("scheduledCardId", scoredCardModel.getScheduledCardId());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("scoredCardId");
		}
	}
	
	
	public void updateByScoredCardId(Handle handle, IScoredCardModel scoredCardModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".scoredcard SET scoredCardId = :scoredCardId, cardId = :cardId, scheduledDateOfScored = :scheduledDateOfScored, boxId = :boxId, quality = :quality, timestamp = :timestamp, points = :points, scheduledCardId = :scheduledCardId WHERE scoredCardId = :scoredCardId");
		statement.bind("scoredCardId", scoredCardModel.getScoredCardId());
		statement.bind("cardId", scoredCardModel.getCardId());
		statement.bind("scheduledDateOfScored", scoredCardModel.getScheduledDateOfScored());
		statement.bind("boxId", scoredCardModel.getBoxId());
		statement.bind("quality", scoredCardModel.getQuality());
		statement.bind("timestamp", scoredCardModel.getTimestamp());
		statement.bind("points", scoredCardModel.getPoints());
		statement.bind("scheduledCardId", scoredCardModel.getScheduledCardId());
		statement.execute();
	}

	public void deleteByScoredCardId(Handle handle, Integer scoredCardId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".scoredcard WHERE scoredCardId = :scoredCardId");
		statement.bind("scoredCardId", scoredCardId);
		statement.execute();
	}

	public IScoredCardModel selectByScoredCardId(Handle handle, Integer scoredCardId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".scoredcard WHERE scoredCardId = :scoredCardId")
			.bind("scoredCardId", scoredCardId)
			.map(new ScoredCardMapper())
			.first();
	}
	
	public List<IScoredCardModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".scoredcard")
			.map(new ScoredCardMapper())
			.list();
	}
}

/*       S.D.G.       */