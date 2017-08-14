package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.model.Ubigeo;

@Component
@Repository(value = "ubigeoDao")
public class UbigeoDaoImpl extends AbstractDao<Integer, Ubigeo> implements UbigeoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Ubigeo> getAllUbigeos() {
		Criteria criteria = createEntityCriteria();
		List<Ubigeo> ubigeos = (List<Ubigeo>) criteria.list();
		
		return ubigeos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Select2Response<Ubigeo> searchUbigeos(String query, Integer page, Integer pageLimit) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.ilike("full_description", query, MatchMode.ANYWHERE));
		
		Integer total = criteria.list().size();
		
		criteria.addOrder(Order.asc("department"));
		criteria.addOrder(Order.asc("province"));
		criteria.addOrder(Order.asc("district"));
		
		page -= 1;
		
		int firstResult = page * pageLimit;
		
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(pageLimit);
		
		List<Ubigeo> ubigeos = (List<Ubigeo>) criteria.list();
		
		Select2Response<Ubigeo> response = new Select2Response<Ubigeo>();
		response.setItems(ubigeos);
		response.setTotal(total);
		
		return response;
	}

}
