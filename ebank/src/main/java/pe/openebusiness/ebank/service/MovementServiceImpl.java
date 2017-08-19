package pe.openebusiness.ebank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.dao.MovementDao;
import pe.openebusiness.ebank.filter.MovementFilter;
import pe.openebusiness.ebank.model.Movement;

@Component
@Service(value = "movementService")
@Transactional
public class MovementServiceImpl implements MovementService {
	
	@Autowired
	MovementDao movementDao;

	@Override
	public DataTableResponse<Movement> getMovemetDataTableByAccount(DataTableRequest<MovementFilter> request,
			Integer account_id) {
		return movementDao.getMovemetDataTableByAccount(request, account_id);
	}

}
