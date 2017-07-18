package pe.openebusiness.ebank.config.service;

import pe.openebusiness.ebank.model.User;

import java.util.List;

public interface UserService {
	
	User findByUsername(String username);
	
	User findProfile(String username);
	
	void updateFailedAttempt(String username);
	
	void resetFailedAttempt(String username);
	
	void updateEndLockDate(String username);
	
	void updatePassword(String username, String password);
	
	boolean validateCurrentPassword(String username, String password);

	//PG
	void disableUser(String username, int valor, String comment);

	List<User> getAllUser();

}
