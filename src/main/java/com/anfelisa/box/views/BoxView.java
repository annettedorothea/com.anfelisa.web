package com.anfelisa.box.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.data.FillBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CardOfBoxDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.ICardOfBoxModel;

public class BoxView {

	public BiConsumer<BoxCreationData, Handle> createBox = (dataContainer, handle) -> {
		// update view
		Integer id = BoxDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" +  id);
	};

	public BiConsumer<BoxCreationData, Handle> updateBox = (dataContainer, handle) -> {
		// update view
		CustomBoxDao.updateBox(handle, dataContainer, dataContainer.getSchema());
	};
	
	public BiConsumer<DeleteBoxData, Handle> deleteBox = (dataContainer, handle) -> {
		// update view
		BoxDao.deleteByBoxId(handle, dataContainer.getBoxId(), dataContainer.getSchema());
	};
	
	public BiConsumer<FillBoxData, Handle> fillBoxWithCards = (dataContainer, handle) -> {
		// update view
		List<ICardOfBoxModel> cards = dataContainer.getCardsToBeAdded();
		for (ICardOfBoxModel card : cards) {
			CardOfBoxDao.insert(handle, card, dataContainer.getSchema());
		}
		dataContainer.setCreatedId(dataContainer.getCardsToBeAdded().size() + "");
	};
	
}

/*                    S.D.G.                    */
