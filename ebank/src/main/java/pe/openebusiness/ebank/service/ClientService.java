package pe.openebusiness.ebank.service;

import java.util.List;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.filter.ClientFilter;
import pe.openebusiness.ebank.model.AddressGroupType;
import pe.openebusiness.ebank.model.AddressType;
import pe.openebusiness.ebank.model.CivilStatus;
import pe.openebusiness.ebank.model.Client;
import pe.openebusiness.ebank.model.ClientAddress;
import pe.openebusiness.ebank.model.ClientContactInformation;
import pe.openebusiness.ebank.model.Country;
import pe.openebusiness.ebank.model.DocumentType;
import pe.openebusiness.ebank.model.EconomicActivity;
import pe.openebusiness.ebank.model.EmploymentSituation;
import pe.openebusiness.ebank.model.Gender;
import pe.openebusiness.ebank.model.HousingType;
import pe.openebusiness.ebank.model.Magnitude;
import pe.openebusiness.ebank.model.PersonType;
import pe.openebusiness.ebank.model.RoadType;
import pe.openebusiness.ebank.model.SectorType;
import pe.openebusiness.ebank.model.Ubigeo;
import pe.openebusiness.ebank.model.ZoneType;

public interface ClientService {
	
	Client findById(Integer id);
	
	ClientAddress getClientAddress(Integer client_id, Integer type_id);
	
	List<AddressType> getAllAddressTypes();
	
	ClientContactInformation getClientContactInfo(Integer client_id);
	
	List<HousingType> getAllHousingTypes();
	
	List<ZoneType> getAllZoneTypes();
	
	List<RoadType> getAllRoadTypes();
	
	List<AddressGroupType> getAllGroupTypes();
	
	List<SectorType> getAllSectorTypes();
	
	List<Ubigeo> getAllUbigeos();

	Select2Response<Ubigeo> searchUbigeos(String query, Integer page, Integer pageLimit);
	
	List<PersonType> getAllPersonTypes();
	
	List<DocumentType> getAllDocumentTypes();
	
	List<Magnitude> getAllMagnitudes();
	
	List<EconomicActivity> getAllActivities();
	
	List<Gender> getAllGenders();
	
	List<Country> getAllCountries();
	
	List<CivilStatus> getAllCivilStatus();
	
	List<EmploymentSituation> getAllSituations();
	
	Select2Response<Country> searchCountry(String query, Integer page, Integer pageLimit);
	
	public CustomHttpResponse edit(Client client);
	
	public CustomHttpResponse editContactInfo(ClientContactInformation contactInformation);
	
	public CustomHttpResponse editAddress(ClientAddress clientAddress);
	
	public DataTableResponse<Client> getClientDataTable(DataTableRequest<ClientFilter> request);

}
