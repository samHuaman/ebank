package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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

}
