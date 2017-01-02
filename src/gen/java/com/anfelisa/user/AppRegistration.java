package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.user.views.*;
import com.anfelisa.user.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateUserResource(jdbi));
		environment.jersey().register(new LoginResource(jdbi));
		environment.jersey().register(new GetPointsResource(jdbi));
		environment.jersey().register(new GetUserInfoResource(jdbi));
		environment.jersey().register(new UpdateUserResource(jdbi));
		environment.jersey().register(new GetCourseSelectionResource(jdbi));
		environment.jersey().register(new AddCoursesResource(jdbi));
		environment.jersey().register(new RemoveCourseResource(jdbi));
		environment.jersey().register(new UpdatePasswordResource(jdbi));
		environment.jersey().register(new ForgotPasswordResource(jdbi));
		environment.jersey().register(new RegisterUserResource(jdbi));
		environment.jersey().register(new UsernameAvailableResource(jdbi));
		environment.jersey().register(new ConfirmEmailResource(jdbi));
	}

	public static void registerConsumers() {
		UserView userView = new UserView();
		LoginLogView loginLogView = new LoginLogView();
		
		AceController.addConsumer("UserCreatedEvent", userView.createUser);
		AceController.addConsumer("UserRegisteredEvent", userView.registerUser);
		AceController.addConsumer("UserLoggedInEvent", loginLogView.userLoggedIn);
		AceController.addConsumer("UserUpdatedEvent", userView.updateUser);
		AceController.addConsumer("CoursesAddedEvent", userView.addCourses);
		AceController.addConsumer("CourseRemovedEvent", userView.removeCourse);
		AceController.addConsumer("PasswordUpdatedEvent", userView.updatePassword);
		AceController.addConsumer("SendEmailEvent", userView.sendForgotPasswordEmail);
		AceController.addConsumer("SendRegistrationEmailEvent", userView.sendRegistrationEmail);
		AceController.addConsumer("EmailConfirmedEvent", userView.confirmEmail);
    }
}

/*                    S.D.G.                    */
