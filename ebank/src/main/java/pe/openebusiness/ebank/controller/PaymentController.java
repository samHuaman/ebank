package pe.openebusiness.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.PaymentFilter;
import pe.openebusiness.ebank.model.Payment;
import pe.openebusiness.ebank.service.PaymentService;

@RestController
@RequestMapping(value = "payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@ResponseBody
	@RequestMapping(value = "getPaymentDataTable")
	private DataTableResponse<Payment> getPaymentDataTable(DataTableRequest<PaymentFilter> request) {
		DataTableResponse<Payment> response = paymentService.getPaymentDataTable(request);
		return response;
	}

}
