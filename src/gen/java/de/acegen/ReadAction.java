/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package de.acegen;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ReadAction<T extends IDataContainer> extends Action<T> {

	static final Logger LOG = LoggerFactory.getLogger(ReadAction.class);
	
	private PersistenceConnection persistenceConnection;
	protected CustomAppConfiguration appConfiguration;
	protected IDaoProvider daoProvider;
	
	public ReadAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionName);
		this.persistenceConnection = persistenceConnection;
		this.appConfiguration = appConfiguration;
		this.daoProvider = daoProvider;
	}

	protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);
	
	protected abstract void initActionDataFromNonDeterministicDataProvider();

	public void apply() {
		DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
		databaseHandle.beginTransaction();
		try {
			if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
				databaseHandle.rollbackTransaction();
				LOG.warn("duplicate request {} {} ", actionName, this.actionData.getUuid());
				databaseHandle.rollbackTransaction();
				return;
			}
			
			if (appConfiguration.getConfig().writeTimeline()) {
				daoProvider.getAceDao().addActionToTimeline(this, databaseHandle.getTimelineHandle());
			}

			this.actionData.setSystemTime(LocalDateTime.now());
			this.initActionData();
			if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
				initActionDataFromNonDeterministicDataProvider();
			}
			this.loadDataForGetRequest(databaseHandle.getReadonlyHandle());
			
			databaseHandle.commitTransaction();
		} catch (IllegalArgumentException x) {
			LOG.error(actionName + " IllegalArgumentException {} ", x.getMessage());
			try {
				if (appConfiguration.getConfig().writeError()) {
					daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle.getTimelineHandle());
				}
				databaseHandle.rollbackTransaction();
			} catch (Exception ex) {
				LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
			}
			throw x;
		} catch (SecurityException x) {
			LOG.error(actionName + " SecurityException");
			try {
				if (appConfiguration.getConfig().writeError()) {
					daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle.getTimelineHandle());
				}
				databaseHandle.rollbackTransaction();
			} catch (Exception ex) {
				LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
			}
			throw x;
		} catch (Exception x) {
			LOG.error(actionName + " Exception {} ", x.getMessage());
			try {
				if (appConfiguration.getConfig().writeError()) {
					daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle.getTimelineHandle());
				}
				databaseHandle.rollbackTransaction();
			} catch (Exception ex) {
				LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
			}
			throw x;
		} finally {
			databaseHandle.close();
		}
		
	}

}




/******* S.D.G. *******/



