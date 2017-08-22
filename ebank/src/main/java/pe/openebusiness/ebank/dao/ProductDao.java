package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.filter.ProductFilter;
import pe.openebusiness.ebank.model.Product;

import java.util.List;

public interface ProductDao {
	
	DataTableResponse<Product> getProductDataTable(DataTableRequest<ProductFilter> request);
	
	CustomHttpResponse edit(Product product, String[] plans);

	Product getProductById(Integer id);
	
	Select2Response<Product> searchProducts(String query, Integer page, Integer pageLimit);

	List<Product> getAllProducts();
<<<<<<< HEAD
<<<<<<< HEAD


=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81

}
