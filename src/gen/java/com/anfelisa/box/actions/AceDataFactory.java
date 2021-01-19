/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.IDataContainer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.anfelisa.box.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class AceDataFactory {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IDataContainer createAceData(String className, String json) {
		try {
			if (className.equals("com.anfelisa.box.actions.CreateBoxAction") ||
					className.equals("com.anfelisa.box.commands.CreateBoxCommand") ||
					className.equals("com.anfelisa.box.events.CreateBoxOkEvent")
			) {
				BoxCreationData data = mapper.readValue(json, BoxCreationData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.CreateReverseBoxAction") ||
					className.equals("com.anfelisa.box.commands.CreateReverseBoxCommand") ||
					className.equals("com.anfelisa.box.events.CreateReverseBoxOkEvent")
			) {
				BoxCreationData data = mapper.readValue(json, BoxCreationData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.UpdateBoxAction") ||
					className.equals("com.anfelisa.box.commands.UpdateBoxCommand") ||
					className.equals("com.anfelisa.box.events.UpdateBoxOkEvent")
			) {
				BoxUpdateData data = mapper.readValue(json, BoxUpdateData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.GetBoxSettingsAction")) {
				BoxSettingsWrapperData data = mapper.readValue(json, BoxSettingsWrapperData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.ScheduleCardsAction") ||
					className.equals("com.anfelisa.box.commands.ScheduleCardsCommand") ||
					className.equals("com.anfelisa.box.events.ScheduleCardsOkEvent")||
					className.equals("com.anfelisa.box.events.ScheduleCardsNullOrEmptyEvent")
			) {
				ScheduledCardsData data = mapper.readValue(json, ScheduledCardsData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.SortCardsOutAction") ||
					className.equals("com.anfelisa.box.commands.SortCardsOutCommand") ||
					className.equals("com.anfelisa.box.events.SortCardsOutOkEvent")||
					className.equals("com.anfelisa.box.events.SortCardsOutNullOrEmptyEvent")
			) {
				SortCardsOutData data = mapper.readValue(json, SortCardsOutData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.ScheduleActiveCardsAction") ||
					className.equals("com.anfelisa.box.commands.ScheduleActiveCardsCommand") ||
					className.equals("com.anfelisa.box.events.ScheduleActiveCardsOkEvent")||
					className.equals("com.anfelisa.box.events.ScheduleActiveCardsNullOrEmptyEvent")
			) {
				ScheduledCardsData data = mapper.readValue(json, ScheduledCardsData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.SortActiveCardsOutAction") ||
					className.equals("com.anfelisa.box.commands.SortActiveCardsOutCommand") ||
					className.equals("com.anfelisa.box.events.SortActiveCardsOutOkEvent")||
					className.equals("com.anfelisa.box.events.SortActiveCardsOutNullOrEmptyEvent")
			) {
				SortCardsOutData data = mapper.readValue(json, SortCardsOutData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.ScoreCardAction") ||
					className.equals("com.anfelisa.box.commands.ScoreCardCommand") ||
					className.equals("com.anfelisa.box.events.ScoreCardScoreEvent")||
					className.equals("com.anfelisa.box.events.ScoreCardReinforceEvent")
			) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.ScoreReinforceCardAction") ||
					className.equals("com.anfelisa.box.commands.ScoreReinforceCardCommand") ||
					className.equals("com.anfelisa.box.events.ScoreReinforceCardKeepEvent")||
					className.equals("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent")
			) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.InitMyBoxesForDayAction") ||
					className.equals("com.anfelisa.box.commands.InitMyBoxesForDayCommand") ||
					className.equals("com.anfelisa.box.events.InitMyBoxesForDayOkEvent")
			) {
				InitMyBoxesDataData data = mapper.readValue(json, InitMyBoxesDataData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.GetBoxesAction")) {
				BoxListData data = mapper.readValue(json, BoxListData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.GetBoxStatisticsAction")) {
				BoxStatisticsListData data = mapper.readValue(json, BoxStatisticsListData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.LoadNextCardAction")) {
				NextCardData data = mapper.readValue(json, NextCardData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.DeleteBoxAction") ||
					className.equals("com.anfelisa.box.commands.DeleteBoxCommand") ||
					className.equals("com.anfelisa.box.events.DeleteBoxDeleteBoxEvent")||
					className.equals("com.anfelisa.box.events.DeleteBoxDeleteCategoryEvent")
			) {
				DeleteBoxData data = mapper.readValue(json, DeleteBoxData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.LoadAllActiveCardsAction")) {
				ActiveCardListData data = mapper.readValue(json, ActiveCardListData.class);
				data.migrateLegacyData(json);
				return data;
			}
		} catch (IOException e) {
			LOG.error("failed to create ace data {} with data {}", className, json, e);
		}

		return null;
	}
}



/******* S.D.G. *******/



