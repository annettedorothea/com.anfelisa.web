/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.BoxModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.data.IUserToCategoryInvitationData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class InviteUserToCategoryCommand extends AbstractInviteUserToCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(InviteUserToCategoryCommand.class);

	public InviteUserToCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected IUserToCategoryInvitationData executeCommand(IUserToCategoryInvitationData data, PersistenceHandle readonlyHandle) {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle, 
				data.getCategoryId());
		if (category == null) {
			throwIllegalArgumentException("categoryDoesNotExist");
		}

		IUserModel invitedUser = this.daoProvider.getUserDao().selectByUsername(readonlyHandle, data.getInvitedUsername());
		if (invitedUser == null) {
			this.throwIllegalArgumentException("userDoesNotExist");
		} else {
			data.setInvitedUserId(invitedUser.getUserId());
		}
		
		if (invitedUser.getUserId().equals(data.getUserId())) {
			this.throwIllegalArgumentException("userCannotInviteHimself");
		}
		
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle, data.getCategoryId(), data.getUserId());
		if (access == null || !access.getEditable()) {
			throwSecurityException();
		}
		
		IUserAccessToCategoryModel alreadyExistingAccess = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle, data.getCategoryId(), invitedUser.getUserId());
		if (alreadyExistingAccess != null) {
			throwIllegalArgumentException("userIsAlreadyInvited");
		}
		
		IBoxModel boxForInvitedUser = new BoxModel();
		boxForInvitedUser.setBoxId(data.getUuid());
		boxForInvitedUser.setCategoryId(data.getCategoryId());
		boxForInvitedUser.setMaxCardsPerDay(10);
		boxForInvitedUser.setUserId(invitedUser.getUserId());
		data.setBoxForInvitedUser(boxForInvitedUser);
		
		this.addOkOutcome(data);
		return data;
	}

}




/******* S.D.G. *******/



