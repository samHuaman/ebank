package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.SpendingGroupType;

@Component
@Repository(value = "spendingGroupDao")
public class SpendingGroupDaoImpl extends AbstractDao<Integer, SpendingGroupType> implements SpendingGroupDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SpendingGroupType> getAllGroups() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("group_type_id"));
		
		List<SpendingGroupType> groupTypes = (List<SpendingGroupType>) criteria.list();
		return groupTypes;
	}

}
