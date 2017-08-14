package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.ProductFilter;
import pe.openebusiness.ebank.model.Product;

public interface ProductDao {
	
	DataTableResponse<Product> getProductDataTable(DataTableRequest<ProductFilter> request);
	
	CustomHttpResponse edit(Product product, String[] plans);

	Product getProductById(Integer id);

}
