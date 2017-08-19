<<<<<<< HEAD
package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.PaymentFilter;
import pe.openebusiness.ebank.model.Payment;

public interface PaymentDao {
	
	DataTableResponse<Payment> getPaymentDataTable(DataTableRequest<PaymentFilter> request);

}
=======
package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.PaymentFilter;
import pe.openebusiness.ebank.model.Payment;

public interface PaymentDao {
	
	DataTableResponse<Payment> getPaymentDataTable(DataTableRequest<PaymentFilter> request);

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
