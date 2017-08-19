package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.filter.ProductFilter;
import pe.openebusiness.ebank.model.Product;
import pe.openebusiness.ebank.model.SubProduct;

import java.util.List;

public interface ProductDao {
	
	DataTableResponse<Product> getProductDataTable(DataTableRequest<ProductFilter> request);
	
	CustomHttpResponse edit(Product product, String[] plans);

	Product getProductById(Integer id);
	
	Select2Response<Product> searchProducts(String query, Integer page, Integer pageLimit);
<<<<<<< HEAD

	List<Product> getAllProducts();
=======
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f

}
