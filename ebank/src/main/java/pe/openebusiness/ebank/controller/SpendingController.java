package pe.openebusiness.ebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.filter.SpendingTypeFilter;
import pe.openebusiness.ebank.model.Spending;
import pe.openebusiness.ebank.model.SpendingGroupType;
import pe.openebusiness.ebank.model.SpendingType;
import pe.openebusiness.ebank.service.SpendingService;

@RestController
@RequestMapping(value = "spending")
public class SpendingController {
	
	@Autowired
	SpendingService spendingService;

	@ResponseBody
	@RequestMapping(value = "getSpendingDataTableByClient")
	private DataTableResponse<Spending> getSpendingDataTableByClient(DataTableRequest<SpendingFilter> request, Integer client_id) {
		DataTableResponse<Spending> response = spendingService.getSpendingDataTableByClient(request, client_id);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllSpendingTypes")
	private List<SpendingType> getAllSpendingTypes() {
		List<SpendingType> spendingTypes = spendingService.getAllSpendingTypes();
		return spendingTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getSpendingTypeDataTable")
	private DataTableResponse<SpendingType> getSpendingTypeDataTable(DataTableRequest<SpendingTypeFilter> request) {
		DataTableResponse<SpendingType> response = spendingService.getSpendingTypeDataTable(request);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllGroups")
	private List<SpendingGroupType> getAllGroups() {
		List<SpendingGroupType> groupTypes = spendingService.getAllGroups();
		return groupTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getSpendingTypeById")
	private SpendingType getSpendingTypeById(Integer id) {
		SpendingType spendingType = spendingService.getSpendingTypeById(id);
		return spendingType;
	}
	
	@ResponseBody
	@RequestMapping(value = "editType")
	private CustomHttpResponse editType(SpendingType spendingType) {
		CustomHttpResponse response = spendingService.editType(spendingType);
		return response;
	}

}
