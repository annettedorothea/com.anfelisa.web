/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.category.events;

import de.acegen.IDaoProvider;
import de.acegen.IEvent;
import de.acegen.ViewProvider;
import com.anfelisa.category.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.acegen.IDataContainer;
import de.acegen.CustomAppConfiguration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class EventFactory {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		try {
			if (eventClass.equals("com.anfelisa.category.events.CreateCategoryOkEvent")) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				CreateCategoryOkEvent event = new CreateCategoryOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.UpdateCategoryOkEvent")) {
				CategoryUpdateData data = mapper.readValue(json, CategoryUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCategoryOkEvent event = new UpdateCategoryOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryOkEvent")) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCategoryOkEvent event = new DeleteCategoryOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.MoveCategoryOkEvent")) {
				CategoryMoveData data = mapper.readValue(json, CategoryMoveData.class);
				data.migrateLegacyData(json);
				MoveCategoryOkEvent event = new MoveCategoryOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.ChangeOrderCategoryOkEvent")) {
				CategoryChangeOrderData data = mapper.readValue(json, CategoryChangeOrderData.class);
				data.migrateLegacyData(json);
				ChangeOrderCategoryOkEvent event = new ChangeOrderCategoryOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		if (eventClass.equals("com.anfelisa.category.events.CreateCategoryOkEvent")) {
			return new CreateCategoryOkEvent((CategoryCreationData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.category.events.UpdateCategoryOkEvent")) {
			return new UpdateCategoryOkEvent((CategoryUpdateData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryOkEvent")) {
			return new DeleteCategoryOkEvent((CategoryDeleteData)data, daoProvider, viewProvider, appConfiguration);
		}


		if (eventClass.equals("com.anfelisa.category.events.MoveCategoryOkEvent")) {
			return new MoveCategoryOkEvent((CategoryMoveData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.category.events.ChangeOrderCategoryOkEvent")) {
			return new ChangeOrderCategoryOkEvent((CategoryChangeOrderData)data, daoProvider, viewProvider, appConfiguration);
		}


		return null;
	}
}



/******* S.D.G. *******/



