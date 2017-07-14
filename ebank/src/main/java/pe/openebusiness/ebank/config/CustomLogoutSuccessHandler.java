package pe.openebusiness.ebank.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component("customLogoutSuccessHandler")
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	
	@Override
	public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		SecurityContextHolder.getContext().setAuthentication(null);
		
		session.setAttribute("username", null);
		session.setAttribute("authorities", null);
		
		res.setStatus(HttpServletResponse.SC_OK);
		
		res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, content-type, cookies");
		res.setHeader("Access-Control-Allow-Credentials", "true");
	}

}
