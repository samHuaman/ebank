package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.Client;

@Component
@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

	@Override
	public Client findById(Integer id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("client_id", id));
		
		Client client = (Client) criteria.uniqueResult();
		return client;
	}

}
