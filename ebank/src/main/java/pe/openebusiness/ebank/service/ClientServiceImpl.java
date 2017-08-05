package pe.openebusiness.ebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.dao.AddressGroupTypeDao;
import pe.openebusiness.ebank.dao.AddressTypeDao;
import pe.openebusiness.ebank.dao.CivilStatusDao;
import pe.openebusiness.ebank.dao.ClientAddressDao;
import pe.openebusiness.ebank.dao.ClientContactInfoDao;
import pe.openebusiness.ebank.dao.ClientDao;
import pe.openebusiness.ebank.dao.CountryDao;
import pe.openebusiness.ebank.dao.DocumentTypeDao;
import pe.openebusiness.ebank.dao.EconomicActivityDao;
import pe.openebusiness.ebank.dao.EmploymentSituationDao;
import pe.openebusiness.ebank.dao.GenderDao;
import pe.openebusiness.ebank.dao.HousingTypeDao;
import pe.openebusiness.ebank.dao.MagnitudeDao;
import pe.openebusiness.ebank.dao.PersonTypeDao;
import pe.openebusiness.ebank.dao.RoadTypeDao;
import pe.openebusiness.ebank.dao.SectorTypeDao;
import pe.openebusiness.ebank.dao.UbigeoDao;
import pe.openebusiness.ebank.dao.ZoneTypeDao;
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

@Component
@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private ClientAddressDao addressDao;
	
	@Autowired
	private AddressTypeDao addressTypeDao;
	
	@Autowired
	private ClientContactInfoDao contactDao;
	
	@Autowired
	private HousingTypeDao housingDao;
	
	@Autowired
	private ZoneTypeDao zoneDao;
	
	@Autowired
	private RoadTypeDao roadDao;
	
	@Autowired
	private AddressGroupTypeDao groupDao;
	
	@Autowired
	private SectorTypeDao sectorDao;
	
	@Autowired
	private UbigeoDao ubigeoDao;
	
	@Autowired
	private PersonTypeDao personTypeDao;
	
	@Autowired
	private DocumentTypeDao documentDao;
	
	@Autowired
	private MagnitudeDao magnitudeDao;
	
	@Autowired
	private EconomicActivityDao economicActivityDao;
	
	@Autowired
	private GenderDao genderDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private CivilStatusDao civilStatusDao;
	
	@Autowired
	private EmploymentSituationDao employmentSituationDao;

	@Override
	public Client findById(Integer id) {
		return clientDao.findById(id);
	}

	@Override
	public ClientAddress getClientAddress(Integer client_id, Integer type_id) {
		return addressDao.getClientAddress(client_id, type_id);
	}

	@Override
	public List<AddressType> getAllAddressTypes() {
		return addressTypeDao.getAllAddressTypes();
	}

	@Override
	public ClientContactInformation getClientContactInfo(Integer client_id) {
		return contactDao.getClientContactInfo(client_id);
	}

	@Override
	public List<HousingType> getAllHousingTypes() {
		return housingDao.getAllHousingTypes();
	}

	@Override
	public List<ZoneType> getAllZoneTypes() {
		return zoneDao.getAllZoneType();
	}

	@Override
	public List<RoadType> getAllRoadTypes() {
		return roadDao.getAllRoadTypes();
	}

	@Override
	public List<AddressGroupType> getAllGroupTypes() {
		return groupDao.getAllGroupType();
	}

	@Override
	public List<SectorType> getAllSectorTypes() {
		return sectorDao.getAllSectorTypes();
	}

	@Override
	public List<Ubigeo> getAllUbigeos() {
		return ubigeoDao.getAllUbigeos();
	}
	
	@Override
	public Select2Response<Ubigeo> searchUbigeos(String query, Integer page, Integer pageLimit) {
		return ubigeoDao.searchUbigeos(query, page, pageLimit);
	}

	@Override
	public List<PersonType> getAllPersonTypes() {
		return personTypeDao.getAllPersonTypes();
	}

	@Override
	public List<DocumentType> getAllDocumentTypes() {
		return documentDao.getAllDocumentTypes();
	}

	@Override
	public List<Magnitude> getAllMagnitudes() {
		return magnitudeDao.getAllMagnitudes();
	}

	@Override
	public List<EconomicActivity> getAllActivities() {
		return economicActivityDao.getAllActivities();
	}

	@Override
	public List<Gender> getAllGenders() {
		return genderDao.getAllGenders();
	}

	@Override
	public List<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}

	@Override
	public List<CivilStatus> getAllCivilStatus() {
		return civilStatusDao.getAllCivilStatus();
	}

	@Override
	public List<EmploymentSituation> getAllSituations() {
		return employmentSituationDao.getAllSituations();
	}

}
