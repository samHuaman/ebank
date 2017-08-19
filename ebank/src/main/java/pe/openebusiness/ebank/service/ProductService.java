package pe.openebusiness.ebank.service;

import java.util.List;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.filter.ProductFilter;
import pe.openebusiness.ebank.filter.SubProductFilter;
import pe.openebusiness.ebank.model.Currency;
import pe.openebusiness.ebank.model.Plan;
import pe.openebusiness.ebank.model.Product;
import pe.openebusiness.ebank.model.ProductType;
import pe.openebusiness.ebank.model.SubProduct;

public interface ProductService {
	
	DataTableResponse<Product> getProductDataTable(DataTableRequest<ProductFilter> request);
	
	List<ProductType> getAllProductType();
	
	List<Currency> getAllCurrencies();
	
	List<Plan> getAllPlans();
	
	CustomHttpResponse edit(Product product, String[] plans);
	
	Product getProductById(Integer id);
	
	DataTableResponse<SubProduct> getSubProductDataTabel(DataTableRequest<SubProductFilter> request);
	
	Select2Response<Product> searchProducts(String query, Integer page, Integer pageLimit);
	
	SubProduct getSubProductById(Integer id);
	
	CustomHttpResponse editSubProduct(SubProduct subProduct);

}
