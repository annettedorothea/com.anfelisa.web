/********************************************************************************
 * generated by de.acegen 1.0.2
 ********************************************************************************/




package de.acegen;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Command<T extends IDataContainer> implements ICommand {

	protected T commandData;
	private String commandName;
	protected ObjectMapper mapper;
	protected IDaoProvider daoProvider;
	protected ViewProvider viewProvider;
	protected CustomAppConfiguration appConfiguration;

	public Command(String commandName, T commandData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super();
		this.commandData = commandData;
		this.commandName = commandName;
		mapper = new ObjectMapper();
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
		this.appConfiguration = appConfiguration;
	}

	protected abstract void executeCommand(PersistenceHandle readonlyHandle);

	public void execute(PersistenceHandle readonlyHandle, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			daoProvider.getAceDao().addCommandToTimeline(this, timelineHandle);
		}
		this.executeCommand(readonlyHandle);
	}

	public IDataContainer getCommandData() {
		return commandData;
	}
	
	@SuppressWarnings("unchecked")
	public void setCommandData(IDataContainer data) {
		commandData = (T)data;
	}

	public String getCommandName() {
		return commandName;
	}

	protected void throwSecurityException() {
		throw new SecurityException();
	}

	protected void throwIllegalArgumentException(String error) {
		throw new IllegalArgumentException(error);
	}

}		



/******* S.D.G. *******/



