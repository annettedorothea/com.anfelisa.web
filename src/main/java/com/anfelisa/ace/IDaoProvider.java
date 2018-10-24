package com.anfelisa.ace;

import org.jdbi.v3.core.Handle;

import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.CustomReinforceCardDao;
import com.anfelisa.box.models.CustomScheduledCardDao;
import com.anfelisa.box.models.ReinforceCardDao;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.card.model.CustomCardDao;
import com.anfelisa.card.models.CardDao;
import com.anfelisa.category.model.CustomCategoryDao;
import com.anfelisa.category.model.CustomUserAccessToCategoryDao;
import com.anfelisa.category.models.CategoryDao;
import com.anfelisa.category.models.UserAccessToCategoryDao;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.EmailConfirmationDao;
import com.anfelisa.user.models.ResetPasswordDao;
import com.anfelisa.user.models.UserDao;

public interface IDaoProvider {

	CardDao getCardDao();

	CategoryDao getCategoryDao();

	UserDao getUserDao();

	EmailConfirmationDao getEmailConfirmationDao();

	void truncateAllViews(Handle handle);

	ResetPasswordDao getResetPasswordDao();

	CustomCategoryDao getCustomCategoryDao();

	CustomCardDao getCustomCardDao();

	CustomUserDao getCustomUserDao();

	AceDao getAceDao();
	
	void addExceptionToTimeline(String uuid, Throwable x, DatabaseHandle databaseHandle);
	
	void addPreparingEventToTimeline(IEvent event, String uuid);
	
	public void addEventToTimeline(IEvent event);
	
	public void addCommandToTimeline(ICommand command);
	
	void addActionToTimeline(IAction action);

	BoxDao getBoxDao();

	CustomBoxDao getCustomBoxDao();

	CustomScheduledCardDao getCustomScheduledCardDao();

	ScheduledCardDao getScheduledCardDao();
	
	ReinforceCardDao getReinforceCardDao();
	
	CustomReinforceCardDao getCustomReinforceCardDao();
	
	UserAccessToCategoryDao getUserAccessToCategoryDao();

	CustomUserAccessToCategoryDao getCustomUserAccessToCategoryDao();

}
