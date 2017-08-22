package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.model.Schedule;

public interface ScheduleDao {
	
	Schedule getLastScheduleByAccount(Integer account_id);
	
	Schedule getOriginalScheduleByAccount(Integer account_id);

<<<<<<< HEAD
}
=======
}
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
