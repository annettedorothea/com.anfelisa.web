'use strict';

class ShowNextWordOfTestAction extends AbstractShowNextWordOfTestAction {

    captureActionParam() {
    	if (localStorage.username) {
	        this.actionParam.username = localStorage.username;
	    }
    	if (localStorage.password) {
	        this.actionParam.password = localStorage.password;
	    }
    	if (localStorage.schema) {
	        this.actionParam.schema = localStorage.schema;
	    }
    	if (localStorage.role) {
	        this.actionParam.role = localStorage.role;
	    }
    	if (localStorage.language) {
	        this.actionParam.language = localStorage.language;
	    }
		this.actionParam.nextRandomIndex = Vocabulary.testState.nextRandomIndex();
    }

    initActionData() {
    	if (this.actionParam.username) {
    		this.actionData.username = this.actionParam.username;
    	}
    	if (this.actionParam.password) {
    		this.actionData.password = this.actionParam.password;
    	}
    	if (this.actionParam.schema) {
    		this.actionData.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.role) {
    		this.actionData.role = this.actionParam.role;
    	}
    	if (this.actionParam.language) {
    		this.actionData.language = this.actionParam.language;
    	}
		this.actionData.nextRandomIndex = this.actionParam.nextRandomIndex;
		this.actionData.wordCount = this.actionParam.wordCount;
		this.actionData.testMode = this.actionParam.testMode;
		this.actionData.wordCount = this.actionParam.wordCount;
    }

    releaseActionParam() {
    	if (this.actionParam.username) {
    		localStorage.username = this.actionParam.username;
    	}
    	if (this.actionParam.password) {
    		localStorage.password = this.actionParam.password;
    	}
    	if (this.actionParam.schema) {
    		localStorage.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.role) {
    		localStorage.role = this.actionParam.role;
    	}
    	if (this.actionParam.language) {
    		localStorage.language = this.actionParam.language;
    	}
    	// release action params during replay
    }
}

/*       S.D.G.       */