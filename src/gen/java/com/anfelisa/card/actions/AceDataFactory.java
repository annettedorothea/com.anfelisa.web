package com.anfelisa.card.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.card.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class AceDataFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IDataContainer createAceData(String className, String json) {
		try {
			if (className.equals("com.anfelisa.card.actions.CreateCardAction") ||
					className.equals("com.anfelisa.card.commands.CreateCardCommand") ||
					className.equals("com.anfelisa.card.events.CreateCardOkEvent")
			) {
				CardCreationData data = mapper.readValue(json, CardCreationData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.UpdateCardAction") ||
					className.equals("com.anfelisa.card.commands.UpdateCardCommand") ||
					className.equals("com.anfelisa.card.events.UpdateCardOkEvent")
			) {
				CardUpdateData data = mapper.readValue(json, CardUpdateData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.DeleteCardAction") ||
					className.equals("com.anfelisa.card.commands.DeleteCardCommand") ||
					className.equals("com.anfelisa.card.events.DeleteCardOkEvent")
			) {
				CardDeleteData data = mapper.readValue(json, CardDeleteData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.GetDuplicatesAction")) {
				CardSearchData data = mapper.readValue(json, CardSearchData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.GetTranslationAction")) {
				CardTranslationData data = mapper.readValue(json, CardTranslationData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.GetCardsAction")) {
				CardListData data = mapper.readValue(json, CardListData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.MoveCardsAction") ||
					className.equals("com.anfelisa.card.commands.MoveCardsCommand") ||
					className.equals("com.anfelisa.card.events.MoveCardsOkEvent")
			) {
				CardIdListData data = mapper.readValue(json, CardIdListData.class);
				data.migrateLegacyData(json);
				return data;
			}
		} catch (IOException e) {
			LOG.error("failed to create ace data {} with data {}", className, json, e);
		}

		return null;
	}
}
