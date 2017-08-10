package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.model.Country;

@Component
@Repository(value = "countryDao")
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getAllCountries() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<Country> countries = (List<Country>) criteria.list();
		return countries;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Select2Response<Country> searchCountries(String query, Integer page, Integer pageLimit) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.ilike("description", query, MatchMode.ANYWHERE));
		
		Integer total = criteria.list().size();
		
		criteria.addOrder(Order.asc("description"));
		
		page -= 1;
		
		int firstResult = page * pageLimit;
		
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(pageLimit);
		
		List<Country> countries = (List<Country>) criteria.list();
		
		Select2Response<Country> response = new Select2Response<Country>();
		response.setItems(countries);
		response.setTotal(total);
		
		return response;
	}

}
