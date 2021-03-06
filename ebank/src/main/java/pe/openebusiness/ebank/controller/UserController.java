package pe.openebusiness.ebank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.config.service.UserService;
import pe.openebusiness.ebank.filter.UserFilter;
import pe.openebusiness.ebank.model.User;

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
	
	@ResponseBody
	@RequestMapping(value = "getUserDataTable")
	public DataTableResponse<User> getUserDataTable(DataTableRequest<UserFilter> request) {
		DataTableResponse<User> response = userService.getUserDataTable(request);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getUserByName")
	private User getUserByName(String username) {
		User user = userService.findByUsername(username);
		return user;
	}
	
	@RequestMapping(value = "getUserById")
	private User getUserById(int id) {
		User user = userService.findById(id);
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
	
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	private String changePassword(String username, String currentPassword, String newPassword) {
		boolean currentPasswordIsValid = userService.validateCurrentPassword(username, currentPassword);
		
		if (currentPasswordIsValid) {
			userService.updatePassword(username, newPassword);
		}
		else {
			return "WARNING";
		}
		
		return "SUCCESS";
	}
	
	@RequestMapping(value = "getUsers")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	private String resetPassword(String username, String password) {
		userService.resetPassword(username, password);
		return "SUCCESS";
	}
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	private String saveUser(User user, String p_password) {
		userService.saveUser(user, p_password);
		return "SUCCESS";
	}

    @RequestMapping(value = "enableUsers")
    private String enableUsers(String username, Integer value, String comment) {
	    userService.disableUser(username,value,comment);
      return "SUCCESS";
    }
    
    @RequestMapping(value = "saveImage", method = RequestMethod.POST)
    private String saveUserImage(String username, @RequestParam("file") MultipartFile file) throws Exception {
    	return userService.saveUserImage(username, file);
    }
    
    @ResponseBody
    @RequestMapping(value = "getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    private byte[] getUserImage(String username) throws Exception {
    	return userService.getUserImage(username);
    }
    
}
