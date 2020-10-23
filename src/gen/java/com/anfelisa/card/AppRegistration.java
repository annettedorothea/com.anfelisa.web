/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.card;

import io.dropwizard.setup.Environment;
import de.acegen.PersistenceConnection;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;

import com.anfelisa.card.resources.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCardPriorityResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetCardsResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetDuplicatesResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new MoveCardsResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ChangeOrderResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ImportCsvResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetTranslationResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
	}
	
	public static void registerConsumers(ViewProvider viewProvider) {
		viewProvider.addConsumer("com.anfelisa.card.events.CreateCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.insert((com.anfelisa.card.data.CardCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.UpdateCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.update((com.anfelisa.card.data.CardUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.UpdateCardPriorityOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.updatePriority((com.anfelisa.card.data.CardUpdatePriorityData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.DeleteCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.delete((com.anfelisa.card.data.CardDeleteData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.MoveCardsOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.moveCards((com.anfelisa.card.data.MoveCardsData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.ChangeOrderOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.changeCardOrder((com.anfelisa.card.data.ChangeCardOrderListData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.ImportCsvOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.bulkInsert((com.anfelisa.card.data.CsvUploadData) dataContainer, handle);
		});
		
	}
}



/******* S.D.G. *******/



