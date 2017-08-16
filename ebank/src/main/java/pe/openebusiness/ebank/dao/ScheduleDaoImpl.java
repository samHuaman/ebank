package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.Schedule;

@Component
@Repository(value = "scheduleDao")
public class ScheduleDaoImpl extends AbstractDao<Integer, Schedule> implements ScheduleDao {

	@Override
	public Schedule getLastScheduleByAccount(Integer account_id) {
		Criteria criteria = createEntityCriteria();
		
		criteria.addOrder(Order.desc("schedule_number"));
		criteria.add(Restrictions.eq("account.account_id", account_id));
		
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		
		Schedule schedule = (Schedule) criteria.uniqueResult();		
		return schedule;
	}

	@Override
	public Schedule getOriginalScheduleByAccount(Integer account_id) {
		Criteria criteria = createEntityCriteria();
		
		criteria.addOrder(Order.asc("schedule_number"));
		criteria.add(Restrictions.eq("account.account_id", account_id));
		
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		
		Schedule schedule = (Schedule) criteria.uniqueResult();		
		return schedule;
	}

}
