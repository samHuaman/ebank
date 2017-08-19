<<<<<<< HEAD
package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.model.Spending;

public interface SpendingDao {
	
	DataTableResponse<Spending> getSpendingDataTableByClient(DataTableRequest<SpendingFilter> request, Integer client_id);

}
=======
package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.model.Spending;

public interface SpendingDao {
	
	DataTableResponse<Spending> getSpendingDataTableByClient(DataTableRequest<SpendingFilter> request, Integer client_id);

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
