package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.ClientFilter;
import pe.openebusiness.ebank.model.Client;

public interface ClientDao {
	
	Client findById(Integer id);
	
	CustomHttpResponse edit(Client client);
	
	DataTableResponse<Client> getClientDataTable(DataTableRequest<ClientFilter> request);

}
