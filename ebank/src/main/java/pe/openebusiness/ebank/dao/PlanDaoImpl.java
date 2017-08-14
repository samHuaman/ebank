package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.Plan;

@Component
@Repository(value = "planDao")
public class PlanDaoImpl extends AbstractDao<Integer, Plan> implements PlanDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> getAllPlans() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<Plan> plans = (List<Plan>) criteria.list();
		return plans;
	}

}
