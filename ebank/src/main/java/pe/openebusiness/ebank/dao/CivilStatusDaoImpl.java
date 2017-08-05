package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.CivilStatus;

@Component
@Repository(value = "civilStatusDao")
public class CivilStatusDaoImpl extends AbstractDao<Integer, CivilStatus> implements CivilStatusDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CivilStatus> getAllCivilStatus() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<CivilStatus> civilStatus = (List<CivilStatus>) criteria.list();
		return civilStatus;
	}

}
