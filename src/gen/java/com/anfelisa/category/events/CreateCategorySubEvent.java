package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryCreationData;

public class CreateCategorySubEvent extends Event<ICategoryCreationData> {

	public CreateCategorySubEvent(ICategoryCreationData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.CreateCategorySubEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
