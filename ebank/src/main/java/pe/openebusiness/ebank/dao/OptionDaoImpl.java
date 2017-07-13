package pe.openebusiness.ebank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.constant.OptionType;
import pe.openebusiness.ebank.model.Option;

@Component
@Repository("optionDao")
public class OptionDaoImpl extends AbstractDao<Integer, Option> implements OptionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Option> getOptionsByRoles(List<Integer> roles) {
		Criteria criteria = createEntityCriteria();
		List<Option> result = new ArrayList<Option>();
		
		criteria.createAlias("roles", "ro");
		criteria.createAlias("optionType", "_type");
		
		criteria.add(Restrictions.in("ro.role_id", roles));
		criteria.add(Restrictions.eq("_type.alias", OptionType.MAIN_MENU));
		criteria.add(Restrictions.eq("visible", 1));

		criteria.addOrder(Order.asc("sequence"));
		
		result = (List<Option>) criteria.list();
		return result;
	}

}
