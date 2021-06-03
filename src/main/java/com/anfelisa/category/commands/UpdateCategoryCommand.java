/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.data.ICategoryUpdateData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class UpdateCategoryCommand extends AbstractUpdateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCategoryCommand.class);

	public UpdateCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected ICategoryUpdateData executeCommand(ICategoryUpdateData data, PersistenceHandle readonlyHandle) {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				data.getCategoryId());
		if (category == null) {
			throwIllegalArgumentException("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, category.getRootCategoryId(), data.getUserId());
		if (access == null || !access.getEditable()) {
			throwSecurityException();
		}
		this.addOkOutcome(data);
		return data;
	}

}

/******* S.D.G. *******/
