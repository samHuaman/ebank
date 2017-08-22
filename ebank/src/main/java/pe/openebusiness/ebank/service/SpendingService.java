package pe.openebusiness.ebank.service;

import java.util.List;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.filter.SpendingTypeFilter;
import pe.openebusiness.ebank.model.Spending;
import pe.openebusiness.ebank.model.SpendingGroupType;
import pe.openebusiness.ebank.model.SpendingType;

public interface SpendingService {
	
	DataTableResponse<Spending> getSpendingDataTableByClient(DataTableRequest<SpendingFilter> request, Integer client_id);
	
	List<SpendingType> getAllSpendingTypes();
	
	DataTableResponse<SpendingType> getSpendingTypeDataTable(DataTableRequest<SpendingTypeFilter> request);
	
	List<SpendingGroupType> getAllGroups();
	
	SpendingType getSpendingTypeById(Integer id);
	
	CustomHttpResponse editType(SpendingType spendingType);

<<<<<<< HEAD
}
=======
}
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
