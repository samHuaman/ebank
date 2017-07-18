package pe.openebusiness.ebank.dao;

import java.util.List;

import pe.openebusiness.ebank.model.User;

import java.util.List;

public interface UserDao {
	
	User findByUsername(String username);
	
	User findProfile(String username);
	
	void updateFailedAttempt(String username);
	
	void resetFailedAttempt(String username);
	
	void updateEndLockDate(String username);
	
	void updatePassword(String username, String password);
	
	boolean validateCurrentPassword(String username, String password);
	
	List<User> getAllUsers();
	
	void resetPassword(String username, String password);
	
	void saveUser(User user, String p_password);

	void disableUser(String username, int valor, String comment);

	List<User> getAllUser();
}
