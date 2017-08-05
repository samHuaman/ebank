package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.ClientContactInformation;

@Component
@Repository(value = "clientContactInfoDao")
public class ClientContactInfoDaoImpl extends AbstractDao<Integer, ClientContactInformation>
		implements ClientContactInfoDao {

	@Override
	public ClientContactInformation getClientContactInfo(Integer client_id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("client.client_id", client_id));

		ClientContactInformation contactInformation = (ClientContactInformation) criteria.uniqueResult();
		return contactInformation;
	}

}
