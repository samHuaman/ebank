package pe.openebusiness.ebank.dao;

import java.util.List;

import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.model.Ubigeo;

public interface UbigeoDao {
	
	List<Ubigeo> getAllUbigeos();
	
	Select2Response<Ubigeo> searchUbigeos(String query, Integer page, Integer pageLimit);

}
