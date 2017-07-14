package pe.openebusiness.ebank.config.service;

import java.util.List;

import pe.openebusiness.ebank.model.User;

public interface UserService {
	
	User findByUsername(String username);
	
	User findProfile(String username);
	
	void updateFailedAttempt(String username);
	
	void resetFailedAttempt(String username);
	
	void updateEndLockDate(String username);
	
	void updatePassword(String username, String password);
	
	boolean validateCurrentPassword(String username, String password);
	
	List<User> getAllUsers();
	
	void resetPassword(String username, String password);

}
