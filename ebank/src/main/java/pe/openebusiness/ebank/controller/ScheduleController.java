package pe.openebusiness.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.FeeFilter;
import pe.openebusiness.ebank.model.Fee;
import pe.openebusiness.ebank.model.Schedule;
import pe.openebusiness.ebank.service.ScheduleService;

@RestController
@RequestMapping(value = "schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@ResponseBody
	@RequestMapping(value = "getLastScheduleByAccount")
	private Schedule getLastScheduleByAccount(Integer account_id) {
		Schedule schedule = scheduleService.getLastScheduleByAccount(account_id);
		return schedule;
	}
	
	@ResponseBody
	@RequestMapping(value = "getFeeDataTable")
	private DataTableResponse<Fee> getFeeDataTable(DataTableRequest<FeeFilter> request, Integer schedule_id) {
		DataTableResponse<Fee> response = scheduleService.getFeeDataTable(request, schedule_id);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getOriginalScheduleByAccount")
	private Schedule getOriginalScheduleByAccount(Integer account_id) {
		Schedule schedule = scheduleService.getOriginalScheduleByAccount(account_id);
		return schedule;
	}

}
