package com.anfelisa.user.actions;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

public class RegisterUserAction extends AbstractRegisterUserAction {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserAction.class);

	public RegisterUserAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public void initActionData() {
	}


}

/*       S.D.G.       */
