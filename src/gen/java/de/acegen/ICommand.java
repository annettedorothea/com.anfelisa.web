/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package de.acegen;

public interface ICommand<T extends IDataContainer> {

	String getCommandName();

	T execute(T data, PersistenceHandle readonlyHandle, PersistenceHandle timelineHandle);

	void publishEvents(T data, PersistenceHandle handle, PersistenceHandle timelineHandle);

	void publishAfterCommitEvents(T data, PersistenceHandle handle, PersistenceHandle timelineHandle);

}




/******* S.D.G. *******/



