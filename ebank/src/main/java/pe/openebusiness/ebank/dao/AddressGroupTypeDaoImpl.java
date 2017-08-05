package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.AddressGroupType;

@Component
@Repository(value = "addressGroupTypeDao")
public class AddressGroupTypeDaoImpl extends AbstractDao<Integer, AddressGroupType> implements AddressGroupTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AddressGroupType> getAllGroupType() {
		Criteria criteria = createEntityCriteria();
		List<AddressGroupType> groupTypes = (List<AddressGroupType>) criteria.list();
		
		return groupTypes;
	}

}
