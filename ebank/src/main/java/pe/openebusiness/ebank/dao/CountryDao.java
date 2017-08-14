package pe.openebusiness.ebank.dao;

import java.util.List;

import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.model.Country;

public interface CountryDao {
	
	List<Country> getAllCountries();
	
	Select2Response<Country> searchCountries(String query, Integer page, Integer pageLimit);

}
