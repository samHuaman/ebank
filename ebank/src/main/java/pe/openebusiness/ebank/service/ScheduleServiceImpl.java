package pe.openebusiness.ebank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.dao.FeeDao;
import pe.openebusiness.ebank.dao.ScheduleDao;
import pe.openebusiness.ebank.filter.FeeFilter;
import pe.openebusiness.ebank.model.Fee;
import pe.openebusiness.ebank.model.Schedule;

@Component
@Service(value = "scheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	ScheduleDao scheduleDao;
	
	@Autowired
	FeeDao feeDao;

	@Override
	public Schedule getLastScheduleByAccount(Integer account_id) {
		return scheduleDao.getLastScheduleByAccount(account_id);
	}

	@Override
	public DataTableResponse<Fee> getFeeDataTable(DataTableRequest<FeeFilter> request, Integer schedule_id) {
		return feeDao.getFeeDataTable(request, schedule_id);
	}

	@Override
	public Schedule getOriginalScheduleByAccount(Integer account_id) {
		return scheduleDao.getOriginalScheduleByAccount(account_id);
	}

}
