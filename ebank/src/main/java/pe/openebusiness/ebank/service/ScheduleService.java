<<<<<<< HEAD
package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.FeeFilter;
import pe.openebusiness.ebank.model.Fee;
import pe.openebusiness.ebank.model.Schedule;

public interface ScheduleService {
	
	Schedule getLastScheduleByAccount(Integer account_id);
	
	public Schedule getOriginalScheduleByAccount(Integer account_id);
	
	DataTableResponse<Fee> getFeeDataTable(DataTableRequest<FeeFilter> request, Integer schedule_id);

}
=======
package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.FeeFilter;
import pe.openebusiness.ebank.model.Fee;
import pe.openebusiness.ebank.model.Schedule;

public interface ScheduleService {
	
	Schedule getLastScheduleByAccount(Integer account_id);
	
	public Schedule getOriginalScheduleByAccount(Integer account_id);
	
	DataTableResponse<Fee> getFeeDataTable(DataTableRequest<FeeFilter> request, Integer schedule_id);

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
