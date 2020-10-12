/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package de.acegen;

public abstract class Action<T extends IDataContainer> implements IAction<T> {

	protected T actionData;
	protected String actionName;

	public Action(String actionName) {
		super();
		this.actionName = actionName;
	}
	
	public void setActionData(T actionData) {
		this.actionData = actionData;
	}

	public String getActionName() {
		return this.actionName;
	}

	public T getActionData() {
		return this.actionData;
	}

	protected void throwSecurityException() {
		throw new SecurityException();
	}

	protected void throwIllegalArgumentException(String error) {
		throw new IllegalArgumentException(error);
	}

}



/******* S.D.G. *******/



