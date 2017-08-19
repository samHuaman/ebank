package pe.openebusiness.ebank.dao;

import java.util.List;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SubProductFilter;
import pe.openebusiness.ebank.model.SubProduct;

public interface SubProductDao {
	
	DataTableResponse<SubProduct> getSubProductDataTable(DataTableRequest<SubProductFilter> request);
	
	SubProduct getSubProductById(Integer id);
	
	CustomHttpResponse edit(SubProduct subProduct);
	
	List<SubProduct> getAllSubProducts();

}
