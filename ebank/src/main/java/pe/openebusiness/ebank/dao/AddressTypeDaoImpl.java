package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.AddressType;

@Component
@Repository("addressTypeDao")
public class AddressTypeDaoImpl extends AbstractDao<Integer, AddressType> implements AddressTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AddressType> getAllAddressTypes() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<AddressType> addressTypes = (List<AddressType>) criteria.list();
		return addressTypes;
	}

}
