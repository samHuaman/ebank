package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.Currency;

@Component
@Repository(value = "currencyDao")
public class CurrencyDaoImpl extends AbstractDao<Integer, Currency> implements CurrencyDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> getAllCurrencies() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<Currency> currencies = (List<Currency>) criteria.list();
		return currencies;
	}

}
