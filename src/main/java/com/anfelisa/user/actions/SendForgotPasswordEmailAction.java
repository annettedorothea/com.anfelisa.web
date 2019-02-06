package com.anfelisa.user.actions;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

public class SendForgotPasswordEmailAction extends AbstractSendForgotPasswordEmailAction {

	static final Logger LOG = LoggerFactory.getLogger(SendForgotPasswordEmailAction.class);

	public SendForgotPasswordEmailAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(jdbi,appConfiguration, daoProvider, viewProvider, e2e);
	}


	
	public void initActionData() {
		// init not replayable data here
	}

}

/*       S.D.G.       */