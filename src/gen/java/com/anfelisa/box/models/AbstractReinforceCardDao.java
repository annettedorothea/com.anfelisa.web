/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.box.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractReinforceCardDao {
	
	public void insert(PersistenceHandle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO public.reinforcecard (reinforcecardid, scheduledcardid, boxid, changedate) VALUES (:reinforcecardid, :scheduledcardid, :boxid, :changedate)");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.execute();
	}
	
	
	public void updateByReinforceCardId(PersistenceHandle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE public.reinforcecard SET reinforcecardid = :reinforcecardid, scheduledcardid = :scheduledcardid, boxid = :boxid, changedate = :changedate WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId()  );
		statement.execute();
	}

	public void deleteByReinforceCardId(PersistenceHandle handle, String reinforceCardId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM public.reinforcecard WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid", reinforceCardId);
		statement.execute();
	}

	public IReinforceCardModel selectByReinforceCardId(PersistenceHandle handle, String reinforceCardId) {
		Optional<IReinforceCardModel> optional = handle.getHandle().createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM public.reinforcecard WHERE reinforcecardid = :reinforcecardid")
			.bind("reinforcecardid", reinforceCardId)
			.map(new ReinforceCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	public void updateByScheduledCardId(PersistenceHandle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE public.reinforcecard SET reinforcecardid = :reinforcecardid, scheduledcardid = :scheduledcardid, boxid = :boxid, changedate = :changedate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId()  );
		statement.execute();
	}

	public void deleteByScheduledCardId(PersistenceHandle handle, String scheduledCardId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM public.reinforcecard WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public IReinforceCardModel selectByScheduledCardId(PersistenceHandle handle, String scheduledCardId) {
		Optional<IReinforceCardModel> optional = handle.getHandle().createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM public.reinforcecard WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ReinforceCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public IReinforceCardModel selectByPrimaryKey(PersistenceHandle handle, String reinforceCardId, String scheduledCardId) {
		Optional<IReinforceCardModel> optional = handle.getHandle().createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM public.reinforcecard WHERE reinforcecardid = :reinforcecardid AND scheduledcardid = :scheduledcardid")
			.bind("reinforcecardid", reinforceCardId)
			.bind("scheduledcardid", scheduledCardId)
			.map(new ReinforceCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM public.reinforcecard";
		if (filterMap != null) {
			int i = 0;
			for(String key : filterMap.keySet()) {
				if (i == 0) {
					sql += " WHERE " + key + " = '" + filterMap.get(key) + "'";
				} else {
					sql += " AND " + key + " = '" + filterMap.get(key) + "'";
				}
				i++;
			}
		}
		return handle.getHandle().createQuery(sql).mapTo(Integer.class).first();
	}

	public List<IReinforceCardModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM public.reinforcecard")
			.map(new ReinforceCardMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE public.reinforcecard CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



