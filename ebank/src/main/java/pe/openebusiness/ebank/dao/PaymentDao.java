package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.PaymentFilter;
import pe.openebusiness.ebank.model.Payment;

public interface PaymentDao {
	
	DataTableResponse<Payment> getPaymentDataTable(DataTableRequest<PaymentFilter> request);

}
