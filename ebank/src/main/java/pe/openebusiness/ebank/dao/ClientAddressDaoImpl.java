<<<<<<< HEAD
package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
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

	@Override
	public CustomHttpResponse edit(ClientAddress clientAddress) {
		String action = "";
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("address_id", clientAddress.getAddress_id()));
		
		CustomHttpResponse response = new CustomHttpResponse();
		ClientAddress _clientAddress = (ClientAddress) criteria.uniqueResult();
		
		if (clientAddress.getAddress_id() != null) {
			if (_clientAddress == null) {
				response.setStatusCode(400);
				response.setMessage("Client address not found");
				
				return response;
			}
			else {
				_clientAddress.setHousingType(clientAddress.getHousingType());
				_clientAddress.setZoneType(clientAddress.getZoneType());
				_clientAddress.setZone_name(clientAddress.getZone_name());
				_clientAddress.setBlock(clientAddress.getBlock());
				_clientAddress.setLot(clientAddress.getLot());
				_clientAddress.setRoadType(clientAddress.getRoadType());
				_clientAddress.setRoad_name(clientAddress.getRoad_name());
				_clientAddress.setRoad_number(clientAddress.getRoad_number());
				_clientAddress.setGroupType(clientAddress.getGroupType());
				_clientAddress.setGroup_name(clientAddress.getGroup_name());
				_clientAddress.setGroup_number(clientAddress.getGroup_number());
				_clientAddress.setSectorType(clientAddress.getSectorType());
				_clientAddress.setSector_name(clientAddress.getSector_name());
				_clientAddress.setReference(clientAddress.getReference());
				_clientAddress.setUbigeo(clientAddress.getUbigeo());
				
				try {
					update(_clientAddress);
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
				persist(clientAddress);
				action = "saved";
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());
				
				return response;
			}	
		}
		
		response.setStatusCode(200);
		response.setMessage("Client address " + action);
		
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

	@Override
	public CustomHttpResponse edit(ClientAddress clientAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}
>>>>>>> branch 'master' of https://github.com/samHuaman/ebank.git
