package pe.openebusiness.ebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.dao.SpendingDao;
import pe.openebusiness.ebank.dao.SpendingGroupDao;
import pe.openebusiness.ebank.dao.SpendingTypeDao;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.filter.SpendingTypeFilter;
import pe.openebusiness.ebank.model.Spending;
import pe.openebusiness.ebank.model.SpendingGroupType;
import pe.openebusiness.ebank.model.SpendingType;

@Component
@Service(value = "spendingService")
@Transactional
public class SpendingServiceImpl implements SpendingService {
	
	@Autowired
	SpendingDao spendingDao;
	
	@Autowired
	SpendingTypeDao typeDao;
	
	@Autowired
	SpendingGroupDao groupDao;

	@Override
	public DataTableResponse<Spending> getSpendingDataTableByClient(DataTableRequest<SpendingFilter> request, Integer client_id) {
		return spendingDao.getSpendingDataTableByClient(request, client_id);
	}

	@Override
	public List<SpendingType> getAllSpendingTypes() {
		return typeDao.getAllSpendingTypes();
	}

	@Override
	public DataTableResponse<SpendingType> getSpendingTypeDataTable(DataTableRequest<SpendingTypeFilter> request) {
		return typeDao.getSpendingTypeDataTable(request);
	}

	@Override
	public List<SpendingGroupType> getAllGroups() {
		return groupDao.getAllGroups();
	}

	@Override
	public SpendingType getSpendingTypeById(Integer id) {
		return typeDao.getSpendingTypeById(id);
	}

	@Override
	public CustomHttpResponse editType(SpendingType spendingType) {
		return typeDao.edit(spendingType);
	}

}
