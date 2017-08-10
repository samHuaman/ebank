package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.EconomicActivity;

@Component
@Repository(value = "economicActivityDao")
public class EconomicActivityDaoImpl extends AbstractDao<Integer, EconomicActivity> implements EconomicActivityDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<EconomicActivity> getAllActivities() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<EconomicActivity> activities = (List<EconomicActivity>) criteria.list();
		return activities;
	}

}
