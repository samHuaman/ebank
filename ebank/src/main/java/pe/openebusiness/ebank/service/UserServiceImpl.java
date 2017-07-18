package pe.openebusiness.ebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.config.service.UserService;
import pe.openebusiness.ebank.dao.UserDao;
import pe.openebusiness.ebank.model.User;

import java.util.List;

@Component
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public User findProfile(String username) {
		return dao.findProfile(username);
	}

	@Override
	public void updateFailedAttempt(String username) {
		dao.updateFailedAttempt(username);
	}

	@Override
	public void resetFailedAttempt(String username) {
		dao.resetFailedAttempt(username);
	}

	@Override
	public void updateEndLockDate(String username) {
		dao.updateEndLockDate(username);
	}

	@Override
	public void updatePassword(String username, String password) {
		dao.updatePassword(username, password);
	}

	@Override
	public boolean validateCurrentPassword(String username, String password) {
		return dao.validateCurrentPassword(username, password);
	}

<<<<<<< HEAD
	//PG
	@Override
	public void disableUser(String username,int valor, String comment) {dao.disableUser(username,valor,comment); }

	@Override
	public List<User> getAllUser(){return dao.getAllUser();}
=======
	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public void resetPassword(String username, String password) {
		dao.resetPassword(username, password);
	}

	@Override
	public void saveUser(User user, String p_password) {
		dao.saveUser(user, p_password);
	}
>>>>>>> 06663c0b69e97bd03328406c07eefd32fdcd2c60

}
