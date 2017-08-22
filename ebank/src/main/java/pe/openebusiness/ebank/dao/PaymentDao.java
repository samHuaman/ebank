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
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
