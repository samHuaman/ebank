<<<<<<< HEAD

package pe.openebusiness.ebank.dao;

import java.util.List;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingTypeFilter;
import pe.openebusiness.ebank.model.SpendingType;

public interface SpendingTypeDao {
	
	List<SpendingType> getAllSpendingTypes();
	
	DataTableResponse<SpendingType> getSpendingTypeDataTable(DataTableRequest<SpendingTypeFilter> request);
	
	SpendingType getSpendingTypeById(Integer id);
	
	CustomHttpResponse edit(SpendingType spendingType);

}
=======
package pe.openebusiness.ebank.dao;

import java.util.List;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingTypeFilter;
import pe.openebusiness.ebank.model.SpendingType;

public interface SpendingTypeDao {
	
	List<SpendingType> getAllSpendingTypes();
	
	DataTableResponse<SpendingType> getSpendingTypeDataTable(DataTableRequest<SpendingTypeFilter> request);
	
	SpendingType getSpendingTypeById(Integer id);
	
	CustomHttpResponse edit(SpendingType spendingType);

}
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
