package pe.openebusiness.ebank.service;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
import java.util.List;

>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.FeeFilter;
import pe.openebusiness.ebank.model.Fee;
import pe.openebusiness.ebank.model.Schedule;

public interface ScheduleService {
<<<<<<< HEAD
	
	Schedule getLastScheduleByAccount(Integer account_id);
	
	public Schedule getOriginalScheduleByAccount(Integer account_id);
	
	DataTableResponse<Fee> getFeeDataTable(DataTableRequest<FeeFilter> request, Integer schedule_id);
<<<<<<< HEAD

}
=======
	
	List<Fee> getPendingFees(Integer schedule_id);

}
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
	
	Schedule getLastScheduleByAccount(Integer account_id);
	
	public Schedule getOriginalScheduleByAccount(Integer account_id);
	
	DataTableResponse<Fee> getFeeDataTable(DataTableRequest<FeeFilter> request, Integer schedule_id);
	
	List<Fee> getPendingFees(Integer schedule_id);

}
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
