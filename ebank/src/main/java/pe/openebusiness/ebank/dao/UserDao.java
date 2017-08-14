package pe.openebusiness.ebank.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.UserFilter;
import pe.openebusiness.ebank.model.User;

public interface UserDao {
	
	User findByUsername(String username);
	
	User findById(Integer id);
	
	User findProfile(String username);
	
	DataTableResponse<User> getUserDataTable(DataTableRequest<UserFilter> request);
	
	void updateFailedAttempt(String username);
	
	void resetFailedAttempt(String username);
	
	void updateEndLockDate(String username);
	
	void updatePassword(String username, String password);
	
	boolean validateCurrentPassword(String username, String password);
	
	List<User> getAllUsers();
	
	void resetPassword(String username, String password);
	
	void saveUser(User user, String p_password);

	void disableUser(String username, Integer valor, String comment);

	List<User> getAllUser();
	
	String saveUserImage(String username, MultipartFile file) throws Exception;
	
	byte[] getUserImage(String username) throws IOException;
	
}
