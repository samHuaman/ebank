package pe.openebusiness.ebank.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import pe.openebusiness.ebank.config.service.UserService;

@Component("customAuthSuccessHandler")
public class CustomAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Autowired
	UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		
		session.setAttribute("username", auth.getName());
		session.setAttribute("authorities", auth.getAuthorities());
		
		res.setStatus(HttpServletResponse.SC_OK);
		
		res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, content-type, cookies");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		
		userService.resetFailedAttempt(auth.getName());
	}

}
