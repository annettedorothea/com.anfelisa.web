package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class ScoredCardDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS public.scoredcard (scoredcardid integer NOT NULL  , cardid integer NOT NULL  , scheduleddateofscored timestamp with time zone  , boxid integer NOT NULL  , quality integer  , timestamp timestamp with time zone NOT NULL  , points integer  , scheduledcardid integer NOT NULL  , CONSTRAINT scoredcard_pkey PRIMARY KEY (scoredcardid), CONSTRAINT scoredcard_cardid_fkey FOREIGN KEY (cardid) REFERENCES public.card ( cardid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT scoredcard_boxid_fkey FOREIGN KEY (boxid) REFERENCES public.box ( boxid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT scoredcard_scheduledcardid_fkey FOREIGN KEY (scheduledcardid) REFERENCES public.scheduledcard ( scheduledcardid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT scoredcard_scoredCardId_unique UNIQUE (scoredCardId))");
	}
	
	public Integer insert(Handle handle, IScoredCardModel scoredCardModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.scoredcard (scoredcardid, cardid, scheduleddateofscored, boxid, quality, timestamp, points, scheduledcardid) VALUES ( (SELECT COALESCE(MAX(scoredcardid),0) + 1 FROM public.scoredcard), :cardid, :scheduleddateofscored, :boxid, :quality, :timestamp, :points, :scheduledcardid) RETURNING scoredcardid");
		statement.bind("cardid",  scoredCardModel.getCardId() );
		statement.bind("scheduleddateofscored",  scoredCardModel.getScheduledDateOfScored() );
		statement.bind("boxid",  scoredCardModel.getBoxId() );
		statement.bind("quality",  scoredCardModel.getQuality() );
		statement.bind("timestamp",  scoredCardModel.getTimestamp() );
		statement.bind("points",  scoredCardModel.getPoints() );
		statement.bind("scheduledcardid",  scoredCardModel.getScheduledCardId() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("scoredcardid");
	}
	
	
	public void updateByScoredCardId(Handle handle, IScoredCardModel scoredCardModel) {
		Update statement = handle.createStatement("UPDATE public.scoredcard SET scoredcardid = :scoredcardid, cardid = :cardid, scheduleddateofscored = :scheduleddateofscored, boxid = :boxid, quality = :quality, timestamp = :timestamp, points = :points, scheduledcardid = :scheduledcardid WHERE scoredcardid = :scoredcardid");
		statement.bind("scoredcardid",  scoredCardModel.getScoredCardId() );
		statement.bind("cardid",  scoredCardModel.getCardId() );
		statement.bind("scheduleddateofscored",  scoredCardModel.getScheduledDateOfScored() );
		statement.bind("boxid",  scoredCardModel.getBoxId() );
		statement.bind("quality",  scoredCardModel.getQuality() );
		statement.bind("timestamp",  scoredCardModel.getTimestamp() );
		statement.bind("points",  scoredCardModel.getPoints() );
		statement.bind("scheduledcardid",  scoredCardModel.getScheduledCardId() );
		statement.execute();
	}

	public void deleteByScoredCardId(Handle handle, Integer scoredCardId) {
		Update statement = handle.createStatement("DELETE FROM public.scoredcard WHERE scoredcardid = :scoredcardid");
		statement.bind("scoredcardid", scoredCardId);
		statement.execute();
	}

	public IScoredCardModel selectByScoredCardId(Handle handle, Integer scoredCardId) {
		return handle.createQuery("SELECT * FROM public.scoredcard WHERE scoredcardid = :scoredcardid")
			.bind("scoredcardid", scoredCardId)
			.map(new ScoredCardMapper())
			.first();
	}
	
	public List<IScoredCardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM public.scoredcard")
			.map(new ScoredCardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.scoredcard");
		statement.execute();
	}

}

/*       S.D.G.       */
