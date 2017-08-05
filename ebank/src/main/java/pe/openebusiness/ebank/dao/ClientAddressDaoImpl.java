package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.ClientAddress;

@Component
@Repository("clientAddressDao")
public class ClientAddressDaoImpl extends AbstractDao<Integer, ClientAddress> implements ClientAddressDao {

	@Override
	public ClientAddress getClientAddress(Integer client_id, Integer type_id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("client.client_id", client_id));
		criteria.add(Restrictions.eq("addressType.type_id", type_id));
		
		ClientAddress clientAddress = (ClientAddress) criteria.uniqueResult();
		return clientAddress;
	}

}
