package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.Gender;

@Component
@Repository(value = "genderDao")
public class GenderDaoImpl extends AbstractDao<Integer, Gender> implements GenderDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Gender> getAllGenders() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<Gender> genders = (List<Gender>) criteria.list();
		return genders;
	}

}
