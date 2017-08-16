package pe.openebusiness.ebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
import pe.openebusiness.ebank.service.ProductService;

@RestController
@RequestMapping(value = "product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@ResponseBody
	@RequestMapping(value = "getProductDataTable")
	private DataTableResponse<Product> getProductDataTable(DataTableRequest<ProductFilter> request) {
		DataTableResponse<Product> response = productService.getProductDataTable(request);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllProductTypes")
	private List<ProductType> getAllProductTypes() {
		List<ProductType> productTypes = productService.getAllProductType();
		return productTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllCurrencies")
	private List<Currency> getAllCurrencies() {
		List<Currency> currencies = productService.getAllCurrencies();
		return currencies;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllPlans")
	private List<Plan> getAllPlans() {
		List<Plan> plans = productService.getAllPlans();
		return plans;
	}
	
	@ResponseBody
	@RequestMapping(value = "edit")
	private CustomHttpResponse edit(Product product, String[] _plans) {
		CustomHttpResponse response = productService.edit(product, _plans);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getProductById")
	private Product getProductById(Integer id) {
		Product product = productService.getProductById(id);
		return product;
	}
	
	@ResponseBody
	@RequestMapping(value = "getSubProductDataTable")
	private DataTableResponse<SubProduct> getSubProductDataTable(DataTableRequest<SubProductFilter> request) {
		DataTableResponse<SubProduct> response = productService.getSubProductDataTabel(request);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "searchProducts")
	private Select2Response<Product> searchProducts(String query, Integer page, Integer pageLimit) {
		if (page == null) {
			page = 1;
		}
		
		Select2Response<Product> response = productService.searchProducts(query, page, pageLimit);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getSubProductById")
	private SubProduct getSubProductById(Integer id) {
		SubProduct subProduct = productService.getSubProductById(id);
		return subProduct;
	}
	
	@ResponseBody
	@RequestMapping(value = "editSubProduct")
	public CustomHttpResponse editSubProduct(SubProduct subProduct) {
		CustomHttpResponse response = productService.editSubProduct(subProduct);
		return response;
	}

}
