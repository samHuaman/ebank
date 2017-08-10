package pe.openebusiness.ebank.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.model.User;

@Component
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
	
	private static final Integer DAYS_ENABLED_DEFAULT = 30;
	//Criteria criteria = createEntityCriteria();

	@Override
	public User findByUsername(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		
		User user = (User) criteria.uniqueResult();
		
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		
		return user;
	}

	@Override
	public User findById(Integer id) {
		Criteria criteria = createEntityCriteria()
				.setProjection(Projections.projectionList()
						.add(Projections.property("user_id"), "user_id")
						.add(Projections.property("username"), "username")
						.add(Projections.property("enabled"), "enabled")
						.add(Projections.property("user_expired_date"), "user_expired_date")
						.add(Projections.property("credentials_expired_date"), "credentials_expired_date")
						.add(Projections.property("email"), "email")
						.add(Projections.property("firstname"), "firstname")						
						.add(Projections.property("lastname"), "lastname")
						.add(Projections.property("days_enabled"), "days_enabled"))
				.setResultTransformer(Transformers.aliasToBean(User.class));
		
		criteria.add(Restrictions.eq("user_id", id));
		
		User user = (User) criteria.uniqueResult();

		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		
		return user;
	}

	@Override
	public User findProfile(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.setProjection(Projections.projectionList()
						.add(Projections.property("user_id"), "user_id")
						.add(Projections.property("username"), "username")
						.add(Projections.property("user_expired_date"), "user_expired_date")
						.add(Projections.property("credentials_expired_date"), "credentials_expired_date")
						.add(Projections.property("email"), "email")
						.add(Projections.property("firstname"), "firstname")
						.add(Projections.property("lastname"), "lastname"))
				.setResultTransformer(Transformers.aliasToBean(User.class));
		
		criteria.add(Restrictions.eq("username", username));
		
		User user = (User) criteria.uniqueResult();
		
		return user;
	}

	@Override
	public void updateFailedAttempt(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		
		Integer value = 1;
		
		User user = (User) criteria.uniqueResult();
		
		if (user.getFailed_attempts() == null) {
			user.setFailed_attempts(value);
		}
		else {
			Integer sum = user.getFailed_attempts() + value;
			user.setFailed_attempts(sum);
		}
		
		update(user);
	}

	@Override
	public void resetFailedAttempt(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		
		Integer value = 0;
		
		User user = (User) criteria.uniqueResult();
		user.setFailed_attempts(value);
		
		update(user);
	}

	@Override
	public void updateEndLockDate(String username) {
		Date date = new Date();
		LocalDateTime ldt = LocalDateTime.now().plusMinutes(30);
		
		date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		
		User user = (User) criteria.uniqueResult();
		user.setEnd_lock_date(date);
		
		update(user);
	}

	@Override
	public void updatePassword(String username, String password) {
		Date date = new Date();
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));

		User user = (User) criteria.uniqueResult();
		LocalDateTime ldt;
		
		if (user.getDays_enabled() == null) {
			ldt = LocalDateTime.now().plusDays(DAYS_ENABLED_DEFAULT);
		}
		else {
			ldt = LocalDateTime.now().plusDays(user.getDays_enabled());
		}		 		
		
		date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		
		user.setPassword(password);
		user.setCredentials_expired_date(date);
		
		update(user);
	}

	@Override
	public boolean validateCurrentPassword(String username, String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		
		User user = (User) criteria.uniqueResult();
		
		if (passwordEncoder.matches(password, user.getPassword())) {
			return true;
		}
		
		return false;
	}


	//PG
	@Override
	public void disableUser(String username, Integer valor,String comment) {

		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username",username));
		User user = (User) criteria.uniqueResult();
		if (valor == 0){
			user.setEnabled(valor);
		}else{
			user.setEnabled(valor);
		}
		user.setEnabled_commentary(comment);
		update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser(){
		Criteria criteria = createEntityCriteria();
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("user_id"),"user_id")
				.add(Projections.property("username"),"username")
				.add(Projections.property("enabled"),"enabled")
				.add(Projections.property("user_expired_date"),"user_expired_date")
				.add(Projections.property("credentials_expired_date"),"credentials_expired_date")
				.add(Projections.property("email"),"email")
				.add(Projections.property("firstname"),"firstname")
				.add(Projections.property("lastname"),"lastname")
				.add(Projections.property("days_enabled"),"days_enabled"))
				.setResultTransformer(Transformers.aliasToBean(User.class));

		criteria.addOrder(Order.asc("username"));
		List<User> users = (List<User>) criteria.list();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Criteria criteria = createEntityCriteria()
				.setProjection(Projections.projectionList()
						.add(Projections.property("user_id"), "user_id")
						.add(Projections.property("username"), "username")
						.add(Projections.property("enabled"), "enabled")
						.add(Projections.property("user_expired_date"), "user_expired_date")
						.add(Projections.property("credentials_expired_date"), "credentials_expired_date")
						.add(Projections.property("email"), "email")
						.add(Projections.property("firstname"), "firstname")						
						.add(Projections.property("lastname"), "lastname")
						.add(Projections.property("days_enabled"), "days_enabled"))
				.setResultTransformer(Transformers.aliasToBean(User.class));
		
		criteria.addOrder(Order.asc("username"));
		
		List<User> users = (List<User>) criteria.list();
		return users;
	}

	@Override
	public void resetPassword(String username, String password) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));

		User user = (User) criteria.uniqueResult();
		
		LocalDateTime ldt = LocalDateTime.now();
		Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		
		user.setEnd_lock_date(now);
		user.setCredentials_expired_date(now);
		user.setPassword(password);
		
		update(user);
	}

	@Override
	public void saveUser(User user, String p_password) {
		Criteria criteria = createEntityCriteria();
		
		if (user.getUser_id() == null) {
			User _user = new User();
			LocalDateTime ldt = LocalDateTime.now();
			Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());			
			
			_user.setUsername(user.getUsername());
			_user.setPassword(p_password);
			_user.setEnabled(1);
			_user.setUser_expired_date(user.getUser_expired_date());
			_user.setCredentials_expired_date(now);
			_user.setEnd_lock_date(now);
			_user.setEmail(user.getEmail());
			_user.setEmail_confirmed(user.getEmail_confirmed());
			_user.setFirstname(user.getFirstname());
			_user.setLastname(user.getLastname());
			_user.setDays_enabled(user.getDays_enabled());
			_user.setFailed_attempts(0);
			
			persist(_user);
		}
		else {
			criteria.add(Restrictions.eq("user_id", user.getUser_id()));
			User _user = (User) criteria.uniqueResult();	

			if (user != null) {
				_user.setEnabled(user.getEnabled());
				_user.setUser_expired_date(user.getUser_expired_date());
				_user.setEmail(user.getEmail());
				_user.setFirstname(user.getFirstname());
				_user.setLastname(user.getLastname());
				_user.setDays_enabled(user.getDays_enabled());
				
				update(_user);
			}
		}
	}

	@Override
	public String saveUserImage(String username, MultipartFile file) throws Exception {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		
		User _user = (User) criteria.uniqueResult();
		
		try {
			byte[] bs = file.getBytes();
			
			if (_user != null) {
				_user.setUser_image(bs);
				update(_user);
			}
			else {
				throw new Exception("User not found");
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return "FILENOTFOUND";
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			return "ERROR";
		}
		
		return "SUCCESS";
	}

	@Override
	public byte[] getUserImage(String username) throws IOException {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		
		User _user = (User) criteria.uniqueResult();
		
		if (_user != null) {
			if (_user.getUser_image() != null) {
				byte[] imageData = _user.getUser_image();
				return imageData;	
			}
			else {
				File file = new File("E:\\default-image.jpeg");
				byte[] defaultImage = new byte[(int) file.length()];
				
				FileInputStream stream = new FileInputStream(file);
				stream.read(defaultImage);
				stream.close();
				
				return defaultImage;
			}
		}
		else {
			return null;
		}		
	}

}
