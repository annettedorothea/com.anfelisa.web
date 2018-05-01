package com.anfelisa.user;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.user.actions.ChangeUserRoleAction;
import com.anfelisa.user.actions.ConfirmEmailAction;
import com.anfelisa.user.actions.DeleteUserAction;
import com.anfelisa.user.actions.ForgotPasswordAction;
import com.anfelisa.user.actions.GetAllUsersAction;
import com.anfelisa.user.actions.GetRoleAction;
import com.anfelisa.user.actions.GetUserProfileAction;
import com.anfelisa.user.actions.RegisterUserAction;
import com.anfelisa.user.actions.ResetPasswordAction;
import com.anfelisa.user.actions.UpdateUserAction;
import com.anfelisa.user.actions.UsernameAvailableAction;
import com.anfelisa.user.views.EmailConfirmationView;
import com.anfelisa.user.views.EmailView;
import com.anfelisa.user.views.ResetPasswordView;
import com.anfelisa.user.views.UserView;

import io.dropwizard.setup.Environment;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new GetUserProfileAction(jdbi));
		environment.jersey().register(new UsernameAvailableAction(jdbi));
		environment.jersey().register(new GetRoleAction(jdbi));
		environment.jersey().register(new GetAllUsersAction(jdbi));
		environment.jersey().register(new UpdateUserAction(jdbi));
		environment.jersey().register(new ForgotPasswordAction(jdbi));
		environment.jersey().register(new ResetPasswordAction(jdbi));
		environment.jersey().register(new RegisterUserAction(jdbi));
		environment.jersey().register(new ConfirmEmailAction(jdbi));
		environment.jersey().register(new ChangeUserRoleAction(jdbi));
		environment.jersey().register(new DeleteUserAction(jdbi));
	}

	public static void registerConsumers() {
				AceController.addConsumer("com.anfelisa.user.events.UpdateUserSuccessEvent", UserView.updateUser);
				AceController.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", ResetPasswordView.insert);
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE || AceController.getAceExecutionMode() == AceExecutionMode.DEV) {
			AceController.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", EmailView.sendForgotPasswordEmail);
		}
				AceController.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", UserView.resetPassword);
				AceController.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", ResetPasswordView.delete);
				AceController.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", UserView.registerUser);
				AceController.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", EmailConfirmationView.insert);
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE || AceController.getAceExecutionMode() == AceExecutionMode.DEV) {
			AceController.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", EmailView.sendRegistrationEmail);
		}
				AceController.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", UserView.confirmEmail);
				AceController.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", EmailConfirmationView.delete);
				AceController.addConsumer("com.anfelisa.user.events.ChangeUserRoleOkEvent", UserView.changeUserRole);
				AceController.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", UserView.deleteUser);
    }
}

/*                    S.D.G.                    */
