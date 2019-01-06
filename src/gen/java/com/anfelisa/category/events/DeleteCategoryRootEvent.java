package com.anfelisa.category.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.CategoryDeleteData;

public class DeleteCategoryRootEvent extends Event<CategoryDeleteData> {

	public DeleteCategoryRootEvent(CategoryDeleteData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.DeleteCategoryRootEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */