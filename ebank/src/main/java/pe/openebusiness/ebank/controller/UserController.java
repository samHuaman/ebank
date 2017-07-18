package pe.openebusiness.ebank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.openebusiness.ebank.config.service.UserService;
import pe.openebusiness.ebank.model.User;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "getProfile")
	private User getProfile() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		User user = new User();
		user = userService.findProfile(username);
		
		return user;		
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		
		return "Logged out";
	}
	
	@RequestMapping(value = "changePassword")
	public String changePassword(String username, String currentPassword, String newPassword) {
		boolean currentPasswordIsValid = userService.validateCurrentPassword(username, currentPassword);
		
		if (currentPasswordIsValid) {
			userService.updatePassword(username, newPassword);
		}
		else {
			return "WARNING";
		}
		
		return "SUCCESS";
	}

	@RequestMapping(value="getUsers")
	public List<User> getAllUser(){return userService.getAllUser();}


    @RequestMapping(value = "enableUsers")
    private String enableUsers(String username, int valor, String comment) {
      userService.disableUser(username,valor,comment);

      return "SUCCESS";
    }

}
