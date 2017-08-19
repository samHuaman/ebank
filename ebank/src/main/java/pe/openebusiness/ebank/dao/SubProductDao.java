<<<<<<< HEAD
package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.model.SubProduct;

import java.util.List;

public interface SubProductDao {

    List<SubProduct> getAllSubProducts();

}
=======
package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SubProductFilter;
import pe.openebusiness.ebank.model.SubProduct;

public interface SubProductDao {
	
	DataTableResponse<SubProduct> getSubProductDataTable(DataTableRequest<SubProductFilter> request);
	
	SubProduct getSubProductById(Integer id);
	
	CustomHttpResponse edit(SubProduct subProduct);

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
