package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.PaymentFilter;
import pe.openebusiness.ebank.model.Payment;

public interface PaymentService {
	
	DataTableResponse<Payment> getPaymentDataTable(DataTableRequest<PaymentFilter> request);

}