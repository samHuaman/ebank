package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.EmploymentSituation;

@Component
@Repository(value = "employmentSituationDao")
public class EmploymentSituationDaoImpl extends AbstractDao<Integer, EmploymentSituation> implements EmploymentSituationDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<EmploymentSituation> getAllSituations() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<EmploymentSituation> situations = (List<EmploymentSituation>) criteria.list();
		return situations;
	}

}
