package pe.openebusiness.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.MovementFilter;
import pe.openebusiness.ebank.model.Movement;
import pe.openebusiness.ebank.service.MovementService;

@RestController
@RequestMapping(value = "movement")
public class MovementController {

	@Autowired
	MovementService movementService;

	@ResponseBody
	@RequestMapping(value = "getMovemetDataTableByAccount")
	private DataTableResponse<Movement> getMovemetDataTableByAccount(DataTableRequest<MovementFilter> request,
			Integer account_id) {
		DataTableResponse<Movement> response = movementService.getMovemetDataTableByAccount(request, account_id);
		return response;
	}

}
