package pe.openebusiness.ebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.dao.OptionDao;
import pe.openebusiness.ebank.model.Option;

@Component
@Service("optionService")
@Transactional
public class OptionServiceImpl implements OptionService {
	
	@Autowired
	OptionDao dao;

	@Override
	public List<Option> getOptionsByRoles(List<Integer> roles) {
		return dao.getOptionsByRoles(roles);
	}

}
