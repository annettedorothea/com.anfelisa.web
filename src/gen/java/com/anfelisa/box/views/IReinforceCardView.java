/********************************************************************************
 * generated by de.acegen 1.0.2
 ********************************************************************************/




package com.anfelisa.box.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.data.IInitMyBoxesDataData;
import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.ISortCardsOutData;

@SuppressWarnings("all")
public interface IReinforceCardView {

	void add(IScoreCardData data, PersistenceHandle handle);
	void remove(IScoreReinforceCardData data, PersistenceHandle handle);
	void update(IScoreReinforceCardData data, PersistenceHandle handle);
	void clear(IInitMyBoxesDataData data, PersistenceHandle handle);
	void deleteAll(IDeleteBoxData data, PersistenceHandle handle);
	void sortOut(ISortCardsOutData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



