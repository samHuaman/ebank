package pe.openebusiness.ebank.service;

import java.util.List;

import pe.openebusiness.ebank.model.Option;

public interface OptionService {
	
	List<Option> getOptionsByRoles(List<Integer> roles);

}
