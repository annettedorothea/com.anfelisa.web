/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.user.events;

import de.acegen.IDaoProvider;
import de.acegen.IEvent;
import de.acegen.ViewProvider;
import com.anfelisa.user.data.*;
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
			if (eventClass.equals("com.anfelisa.user.events.RegisterUserOkEvent")) {
				UserRegistrationData data = mapper.readValue(json, UserRegistrationData.class);
				data.migrateLegacyData(json);
				RegisterUserOkEvent event = new RegisterUserOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ConfirmEmailOkEvent")) {
				ConfirmEmailData data = mapper.readValue(json, ConfirmEmailData.class);
				data.migrateLegacyData(json);
				ConfirmEmailOkEvent event = new ConfirmEmailOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ForgotPasswordOkEvent")) {
				ForgotPasswordData data = mapper.readValue(json, ForgotPasswordData.class);
				data.migrateLegacyData(json);
				ForgotPasswordOkEvent event = new ForgotPasswordOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ResetPasswordOkEvent")) {
				ResetPasswordWithNewPasswordData data = mapper.readValue(json, ResetPasswordWithNewPasswordData.class);
				data.migrateLegacyData(json);
				ResetPasswordOkEvent event = new ResetPasswordOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ChangeUserRoleOkEvent")) {
				ChangeUserRoleData data = mapper.readValue(json, ChangeUserRoleData.class);
				data.migrateLegacyData(json);
				ChangeUserRoleOkEvent event = new ChangeUserRoleOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.DeleteUserOkEvent")) {
				DeleteUserData data = mapper.readValue(json, DeleteUserData.class);
				data.migrateLegacyData(json);
				DeleteUserOkEvent event = new DeleteUserOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		if (eventClass.equals("com.anfelisa.user.events.RegisterUserOkEvent")) {
			return new RegisterUserOkEvent((UserRegistrationData)data, daoProvider, viewProvider, appConfiguration);
		}



		if (eventClass.equals("com.anfelisa.user.events.ConfirmEmailOkEvent")) {
			return new ConfirmEmailOkEvent((ConfirmEmailData)data, daoProvider, viewProvider, appConfiguration);
		}



		if (eventClass.equals("com.anfelisa.user.events.ForgotPasswordOkEvent")) {
			return new ForgotPasswordOkEvent((ForgotPasswordData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.user.events.ResetPasswordOkEvent")) {
			return new ResetPasswordOkEvent((ResetPasswordWithNewPasswordData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.user.events.ChangeUserRoleOkEvent")) {
			return new ChangeUserRoleOkEvent((ChangeUserRoleData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.user.events.DeleteUserOkEvent")) {
			return new DeleteUserOkEvent((DeleteUserData)data, daoProvider, viewProvider, appConfiguration);
		}


		return null;
	}
}



/******* S.D.G. *******/



