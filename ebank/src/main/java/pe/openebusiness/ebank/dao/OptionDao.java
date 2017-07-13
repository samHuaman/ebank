package pe.openebusiness.ebank.dao;

import java.util.List;

import pe.openebusiness.ebank.model.Option;

public interface OptionDao {
	
	List<Option> getOptionsByRoles(List<Integer> roles);

}
