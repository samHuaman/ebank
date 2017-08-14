package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.Magnitude;

@Component
@Repository(value = "magnitudeDao")
public class MagnitudeDaoImpl extends AbstractDao<Integer, Magnitude> implements MagnitudeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Magnitude> getAllMagnitudes() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<Magnitude> magnitudes = (List<Magnitude>) criteria.list();
		return magnitudes;
	}

}
