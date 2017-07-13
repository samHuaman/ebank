package pe.openebusiness.ebank.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import pe.openebusiness.ebank.config.service.UserService;
import pe.openebusiness.ebank.model.User;

@Component("customAuthFailureHandler")
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	private static final Integer MAX_FAILED_ATTEMPTS = 3;
	
	@Autowired
	UserService userService;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException exception)
			throws IOException, ServletException {
		logger.info("Inicio de sesion fallido.");
		
		res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, content-type, cookies");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		
		String username = req.getParameter("username");
		User user = new User();
		
		if (username != null) {
			user = userService.findByUsername(username);
		}
		
		if (user == null) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		else {
			if (exception.getClass().isAssignableFrom(CredentialsExpiredException.class)) {
				res.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			}
			else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
				res.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			}
			else if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				sumFailedAttempt(user);
			}
			else if (exception.getClass().isAssignableFrom(LockedException.class)) {
				res.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
			}
			else {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
	}

	private void sumFailedAttempt(User user) {
		if (user.getFailed_attempts() < MAX_FAILED_ATTEMPTS) {
			userService.updateFailedAttempt(user.getUsername());
		}
		else {
			userService.updateEndLockDate(user.getUsername());
			userService.resetFailedAttempt(user.getUsername());
		}
	}
}
