package com.anfelisa.card.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.card.models.ICardWithInfoModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetCardsAction extends AbstractGetCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsAction.class);

	public GetCardsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider,
			ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
	}

	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				actionData.getCategoryId());
		if (category == null) {
			throwIllegalArgumentException("category does not exist");
		}
		IUserAccessToCategoryModel userAccessToCategoryModel = daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, actionData.getCategoryId(), actionData.getUserId());
		if (userAccessToCategoryModel == null) {
			throwSecurityException();
		}
		IBoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle,
				category.getRootCategoryId(), actionData.getUserId());
		List<ICardWithInfoModel> allCards = daoProvider.getCardDao().selectAllOfCategoryWithBoxInfo(readonlyHandle,
				actionData.getCategoryId(), box.getBoxId());
		this.actionData.setCardList(allCards);
	}

	@Override
	public void initActionData() {
	}

}

/* S.D.G. */
