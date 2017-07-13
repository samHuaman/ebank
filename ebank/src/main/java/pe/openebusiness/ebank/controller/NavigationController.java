package pe.openebusiness.ebank.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.openebusiness.ebank.config.service.UserService;
import pe.openebusiness.ebank.model.Option;
import pe.openebusiness.ebank.model.Role;
import pe.openebusiness.ebank.model.User;
import pe.openebusiness.ebank.service.OptionService;

@RestController
@RequestMapping(value = "navigation")
public class NavigationController {
	
	@Autowired
	OptionService optionService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "getMenu")
	private Collection<Option> getPrincipalMenu() {
		List<Option> options;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String username = auth.getName();
		
		User user = new User();
		user = userService.findByUsername(username);
		
		List<Integer> roles = new ArrayList<Integer>();
		
		for (Role role : user.getRoles()) {
			roles.add(role.getRole_id());
		}
		
		options = optionService.getOptionsByRoles(roles);
		return options;
	}

}
