package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.model.Schedule;

public interface ScheduleDao {
	
	Schedule getLastScheduleByAccount(Integer account_id);
	
	Schedule getOriginalScheduleByAccount(Integer account_id);

}
