package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.model.Spending;

public interface SpendingService {
	
	DataTableResponse<Spending> getSpendingDataTable(DataTableRequest<SpendingFilter> request);

}
