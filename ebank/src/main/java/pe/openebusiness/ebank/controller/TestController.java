package pe.openebusiness.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.openebusiness.ebank.config.service.UserService;
import pe.openebusiness.ebank.model.User;

@RestController
@RequestMapping(value = "test")
public class TestController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "user/get")
	private User getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		User user = new User();
		user = userService.findByUsername(username);
		
		return user;
	}

}
