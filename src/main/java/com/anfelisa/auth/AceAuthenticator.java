package com.anfelisa.auth;

import java.util.Optional;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class AceAuthenticator implements Authenticator<BasicCredentials, AuthUser> {

	private DBI jdbi;

	private UserDao userDao = new UserDao();

	public AceAuthenticator(DBI jdbi) {
		super();
		this.jdbi = jdbi;
	}

	public Optional<AuthUser> authenticate(BasicCredentials credentials) throws AuthenticationException {
		String username = credentials.getUsername();
		Handle handle = this.jdbi.open();
		try {
			IUserModel user = userDao.selectByUsername(handle, username);
			if (user != null && user.getPassword().equals(credentials.getPassword())) {
				return Optional.of(new AuthUser(credentials.getUsername(), credentials.getPassword(), AuthUser.ADMIN));
			} else {
				return Optional.empty();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			handle.close();
		}
	}
}
