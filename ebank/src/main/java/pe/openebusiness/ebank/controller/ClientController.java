package pe.openebusiness.ebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.Select2Response;
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
import pe.openebusiness.ebank.service.ClientService;

@RestController
@RequestMapping(value = "client")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@ResponseBody
	@RequestMapping(value = "findById")
	private Client findById(Integer id) {
		Client client = clientService.findById(id);
		return client;
	}
	
	@ResponseBody
	@RequestMapping(value = "getClientAddress")
	private ClientAddress getClientAddress(Integer client_id, Integer type_id) {
		ClientAddress address = clientService.getClientAddress(client_id, type_id);
		return address;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllAddressType")
	private List<AddressType> getAllAddressType() {
		List<AddressType> addressTypes = clientService.getAllAddressTypes();
		return addressTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getClientContactInfo")
	private ClientContactInformation getClientContactInfo(Integer client_id) {
		ClientContactInformation contactInformation = clientService.getClientContactInfo(client_id);
		return contactInformation;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllHousingTypes")
	private List<HousingType> getAllHousingTypes() {
		List<HousingType> housingTypes = clientService.getAllHousingTypes();
		return housingTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllZoneTypes")
	private List<ZoneType> getAllZoneTypes() {
		List<ZoneType> zoneTypes = clientService.getAllZoneTypes();
		return zoneTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllRoadTypes")
	private List<RoadType> getAllRoadTypes() {
		List<RoadType> roadTypes = clientService.getAllRoadTypes();
		return roadTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllGroupTypes")
	private List<AddressGroupType> getAllGroupTypes() {
		List<AddressGroupType> groupTypes = clientService.getAllGroupTypes();
		return groupTypes;
	}

	@ResponseBody
	@RequestMapping(value = "getAllSectorTypes")
	private List<SectorType> getAllSectorTypes() {
		List<SectorType> sectorTypes = clientService.getAllSectorTypes();
		return sectorTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllUbigeos")
	private List<Ubigeo> getAllUbigeos() {
		List<Ubigeo> ubigeos = clientService.getAllUbigeos();
		return ubigeos;
	}
	
	@ResponseBody
	@RequestMapping(value = "searchUbigeos")
	private Select2Response<Ubigeo> searchUbigeos(String str, Integer page, Integer pageLimit) {
		if (page == null) {
			page = 1;
		}
		
		Select2Response<Ubigeo> ubigeos = clientService.searchUbigeos(str, page, pageLimit);
		return ubigeos; 
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllPersonTypes")
	private List<PersonType> getAllPersonTypes() {
		List<PersonType> personTypes = clientService.getAllPersonTypes();
		return personTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllDocumentTypes")
	private List<DocumentType> getAllDocumentTypes() {
		List<DocumentType> documentTypes = clientService.getAllDocumentTypes();
		return documentTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllMagnitudes")
	private List<Magnitude> getAllMagnitudes() {
		List<Magnitude> magnitudes = clientService.getAllMagnitudes();
		return magnitudes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllActivities")
	private List<EconomicActivity> getAllActivities() {
		List<EconomicActivity> activities = clientService.getAllActivities();
		return activities;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllGenders")
	private List<Gender> getAllGenders() {
		List<Gender> genders = clientService.getAllGenders();
		return genders;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllCountries")
	private List<Country> getAllCountries() {
		List<Country> countries = clientService.getAllCountries();
		return countries;
	}
	
	@ResponseBody
	@RequestMapping(value = "searchCountries")
	private Select2Response<Country> searchCountries(String query, Integer page, Integer pageLimit) {
		if (page == null) {
			page = 1;
		}
		
		Select2Response<Country> response = clientService.searchCountry(query, page, pageLimit);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllCivilStatus")
	private List<CivilStatus> getAllCivilStatus() {
		List<CivilStatus> civilStatus = clientService.getAllCivilStatus();
		return civilStatus;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllSituations")
	private List<EmploymentSituation> getAllSituations() {
		List<EmploymentSituation> situations = clientService.getAllSituations();
		return situations;
	}
	
	@ResponseBody
	@RequestMapping(value = "editClient", method = RequestMethod.POST)
	private CustomHttpResponse editClient(Client client) {
		CustomHttpResponse response = clientService.edit(client);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "editContactInfo", method = RequestMethod.POST)
	private CustomHttpResponse editContactInfo(ClientContactInformation contactInformation) {
		CustomHttpResponse response = clientService.editContactInfo(contactInformation);
		return response;
	}
	
}
