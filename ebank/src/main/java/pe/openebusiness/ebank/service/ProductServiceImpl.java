package pe.openebusiness.ebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.dao.CurrencyDao;
import pe.openebusiness.ebank.dao.PlanDao;
import pe.openebusiness.ebank.dao.ProductDao;
import pe.openebusiness.ebank.dao.ProductTypeDao;
import pe.openebusiness.ebank.filter.ProductFilter;
import pe.openebusiness.ebank.model.Currency;
import pe.openebusiness.ebank.model.Plan;
import pe.openebusiness.ebank.model.Product;
import pe.openebusiness.ebank.model.ProductType;

@Component
@Service(value = "productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductTypeDao typeDao;
	
	@Autowired
	CurrencyDao currencyDao;
	
	@Autowired
	PlanDao planDao;

	@Override
	public DataTableResponse<Product> getProductDataTable(DataTableRequest<ProductFilter> request) {
		return productDao.getProductDataTable(request);
	}

	@Override
	public List<ProductType> getAllProductType() {
		return typeDao.getAllProductType();
	}

	@Override
	public List<Currency> getAllCurrencies() {
		return currencyDao.getAllCurrencies();
	}

	@Override
	public List<Plan> getAllPlans() {
		return planDao.getAllPlans();
	}

	@Override
	public CustomHttpResponse edit(Product product, String[] plans) {
		return productDao.edit(product, plans);
	}

	@Override
	public Product getProductById(Integer id) {
		return productDao.getProductById(id);
	}

}
