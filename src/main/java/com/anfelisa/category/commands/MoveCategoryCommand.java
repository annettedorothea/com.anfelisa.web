/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.data.ICategoryMoveData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class MoveCategoryCommand extends AbstractMoveCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(MoveCategoryCommand.class);

	public MoveCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected ICategoryMoveData executeCommand(ICategoryMoveData data, PersistenceHandle readonlyHandle) {
		ICategoryModel movedCategory = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				data.getMovedCategoryId());

		ICategoryModel targetCategory = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				data.getTargetCategoryId());

		if (movedCategory == null || targetCategory == null) {
			throwIllegalArgumentException("movedCategoriesMustNotBeNull");
		}

		IUserAccessToCategoryModel accessToMovedCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, data.getMovedCategoryId(), data.getUserId());
		if (accessToMovedCategory == null || !accessToMovedCategory.getEditable()) {
			throwSecurityException();
		}
		IUserAccessToCategoryModel accessToTargetCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, data.getTargetCategoryId(), data.getUserId());
		if (accessToTargetCategory == null || !accessToTargetCategory.getEditable()) {
			throwSecurityException();
		}

		if (!movedCategory.getRootCategoryId().equals(targetCategory.getRootCategoryId())) {
			throwIllegalArgumentException("categoriesMustBeInSameRootCategory");
		}
		
		if (targetCategory.getCategoryId().equals(movedCategory.getCategoryId())) {
			throwIllegalArgumentException("cannotMoveCategoryToItself");
		}

		if (isChildOf(movedCategory, targetCategory, readonlyHandle)) {
			throwIllegalArgumentException("cannotMoveCategoryToOneOfItsChildren");
		}
		
		if (targetCategory.getCategoryId().equals(movedCategory.getParentCategoryId())) {
			this.addNoMoveOutcome(data);
		} else {
			data.setCategoryIndexWhereRemoved(movedCategory.getCategoryIndex());
			data.setParentCategoryIdWhereRemoved(movedCategory.getParentCategoryId());

			Integer categoryIndexInTargetCategory = this.daoProvider.getCategoryDao()
					.selectMaxIndexInCategory(readonlyHandle, data.getTargetCategoryId());
			if (categoryIndexInTargetCategory == null) {
				categoryIndexInTargetCategory = 1;
			} else {
				categoryIndexInTargetCategory++;
			}
			movedCategory.setCategoryIndex(categoryIndexInTargetCategory);
			movedCategory.setParentCategoryId(data.getTargetCategoryId());

			data.setMovedCategory(movedCategory);

			this.addOkOutcome(data);
		}
		return data;
	}

	private boolean isChildOf(ICategoryModel parent, ICategoryModel child, PersistenceHandle readonlyHandle) {
		if (child.getParentCategoryId() == null) {
			return false;
		}
		if (child.getParentCategoryId().equals(parent.getCategoryId())) {
			return true;
		}
		return isChildOf(parent,
				this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle, child.getParentCategoryId()),
				readonlyHandle);
	}

}




/******* S.D.G. *******/



