package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.PersonType;

@Component
@Repository(value = "personTypeDao")
public class PersonTypeDaoImpl extends AbstractDao<Integer, PersonType> implements PersonTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonType> getAllPersonTypes() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<PersonType> personTypes = (List<PersonType>) criteria.list();
		return personTypes;
	}

}
