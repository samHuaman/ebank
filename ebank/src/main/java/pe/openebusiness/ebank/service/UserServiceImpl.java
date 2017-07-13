package pe.openebusiness.ebank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.config.service.UserService;
import pe.openebusiness.ebank.dao.UserDao;
import pe.openebusiness.ebank.model.User;

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

}
