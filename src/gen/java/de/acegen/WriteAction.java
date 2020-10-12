/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package de.acegen;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WriteAction<T extends IDataContainer> extends Action<T> {

	static final Logger LOG = LoggerFactory.getLogger(WriteAction.class);
	
	private PersistenceConnection persistenceConnection;
	protected CustomAppConfiguration appConfiguration;
	protected IDaoProvider daoProvider;
	protected ViewProvider viewProvider;
	
	public WriteAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionName);
		this.persistenceConnection = persistenceConnection;
		this.appConfiguration = appConfiguration;
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
	}

	protected abstract void initActionDataFromNonDeterministicDataProvider();

	protected abstract ICommand getCommand();

	public void apply() {
		DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
		databaseHandle.beginTransaction();
		try {
			if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
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
			
			ICommand command = this.getCommand();
			command.execute(databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());
			command.publishEvents(databaseHandle.getHandle(), databaseHandle.getTimelineHandle());
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
			LOG.error(actionName + " SecurityException {} ", x.getMessage());
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



