package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.model.ClientContactInformation;

public interface ClientContactInfoDao {
	
	ClientContactInformation getClientContactInfo(Integer client_id);

}
