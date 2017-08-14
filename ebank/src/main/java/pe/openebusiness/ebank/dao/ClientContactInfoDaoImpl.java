<<<<<<< HEAD
package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
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

	@Override
	public CustomHttpResponse edit(ClientContactInformation contactInformation) {
		String action = "";
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("contact_information_id", contactInformation.getContact_information_id()));
		
		CustomHttpResponse response = new CustomHttpResponse();
		ClientContactInformation _contactInformation = (ClientContactInformation) criteria.uniqueResult();
		
		if (contactInformation.getContact_information_id() != null) {
			if (_contactInformation == null) {
				response.setStatusCode(400);
				response.setMessage("Client not found");
				
				return response;
			}
			else {
				_contactInformation.setEmail(contactInformation.getEmail());
				_contactInformation.setHome_phone(contactInformation.getHome_phone());
				_contactInformation.setCellphone(contactInformation.getCellphone());
				
				try {
					update(_contactInformation);
					action = "edited";
				} catch (Exception ex) {
					response.setStatusCode(500);
					response.setMessage(ex.getMessage());
					response.setStackTrace(ex.getStackTrace());
					
					return response;
				}
			}
		}
		else {
			try {
				persist(contactInformation);
				action = "saved";
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());
				
				return response;
			}
		}
		
		response.setStatusCode(200);
		response.setMessage("Client contact info " + action);
		
		return response;
	}

}
=======
package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
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

	@Override
	public CustomHttpResponse edit(ClientContactInformation contactInformation) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("contact_information_id", contactInformation.getContact_information_id()));
		
		CustomHttpResponse response = new CustomHttpResponse();
		ClientContactInformation _contactInformation = (ClientContactInformation) criteria.uniqueResult();
		
		if (_contactInformation == null) {
			response.setStatusCode(400);
			response.setMessage("Client not found");
			
			return response;
		}
		else {
			_contactInformation.setEmail(contactInformation.getEmail());
			_contactInformation.setHome_phone(contactInformation.getHome_phone());
			_contactInformation.setCellphone(contactInformation.getCellphone());
			
			try {
				update(_contactInformation);
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());
				
				return response;
			}
			
			response.setStatusCode(200);
			response.setMessage("Client contact info edited");
			
			return response;
		}
	}

}
>>>>>>> branch 'master' of https://github.com/samHuaman/ebank.git
