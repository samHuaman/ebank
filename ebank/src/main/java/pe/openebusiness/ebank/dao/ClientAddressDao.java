package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.ClientAddress;

public interface ClientAddressDao {
	
	ClientAddress getClientAddress(Integer client_id, Integer type_id);
	
	CustomHttpResponse edit(ClientAddress clientAddress);

}
