package pe.openebusiness.ebank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.dao.SpendingDao;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.model.Spending;

@Component
@Service(value = "spendingService")
@Transactional
public class SpendingServiceImpl implements SpendingService {
	
	@Autowired
	SpendingDao spendingDao;

	@Override
	public DataTableResponse<Spending> getSpendingDataTable(DataTableRequest<SpendingFilter> request) {
		return spendingDao.getSpendingDataTable(request);
	}

}
