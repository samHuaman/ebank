package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
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

	@Override
	public CustomHttpResponse edit(Client client) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("client_id", client.getClient_id()));
		
		CustomHttpResponse response = new CustomHttpResponse();
		Client _client = (Client) criteria.uniqueResult();
		
		if (_client == null) {
			response.setStatusCode(400);
			response.setMessage("Client not found");
			
			return response;
		}
		else {
			_client.setPersonType(client.getPersonType());
			_client.setDocumentType(client.getDocumentType());
			_client.setDocument_number(client.getDocument_number());
			_client.setMagnitude(client.getMagnitude());
			_client.setTaxpayer_id_number(client.getTaxpayer_id_number());
			_client.setEconomicActivity(client.getEconomicActivity());
			_client.setBusiness_name(client.getBusiness_name());
			_client.setFristname(client.getFristname());
			_client.setSecondname(client.getSecondname());
			_client.setLastname_a(client.getLastname_a());
			_client.setLastname_b(client.getLastname_b());
			_client.setMarried_surname(client.getMarried_surname());
			_client.setGender(client.getGender());
			_client.setBirthdate(client.getBirthdate());
			_client.setNacionality(client.getNacionality());
			_client.setResidence_country(client.getResidence_country());
			_client.setCivilStatus(client.getCivilStatus());
			_client.setEmploymentSituation(client.getEmploymentSituation());
			_client.setData_protection_act(client.getData_protection_act());
			
			try {
				update(_client);
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());
				
				return response;
			}
			
			response.setStatusCode(200);
			response.setMessage("Client edited");
			
			return response;
		}
	}

}
