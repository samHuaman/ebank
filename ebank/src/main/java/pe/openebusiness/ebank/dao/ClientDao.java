package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.Client;

public interface ClientDao {
	
	Client findById(Integer id);
	
	CustomHttpResponse edit(Client client);

}
