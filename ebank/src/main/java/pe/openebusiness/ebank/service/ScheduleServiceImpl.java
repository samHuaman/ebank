package pe.openebusiness.ebank.service;

import java.util.List;

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

<<<<<<< HEAD
<<<<<<< HEAD
}
=======
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
	@Override
	public List<Fee> getPendingFees(Integer schedule_id) {
		return feeDao.getPendingFees(schedule_id);
	}

}
<<<<<<< HEAD
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
