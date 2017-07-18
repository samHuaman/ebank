package pe.openebusiness.ebank.dao;

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
	public User findProfile(String username) {
		Criteria criteria = createEntityCriteria();
		criteria
				.setProjection(Projections.projectionList()
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
	public void disableUser(String username, int valor,String comment) {

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
}
