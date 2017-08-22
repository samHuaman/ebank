package pe.openebusiness.ebank.dao;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
import java.util.List;

>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SubProductFilter;
import pe.openebusiness.ebank.model.SubProduct;

import java.util.List;

public interface SubProductDao {
	
	DataTableResponse<SubProduct> getSubProductDataTable(DataTableRequest<SubProductFilter> request);
	
	SubProduct getSubProductById(Integer id);
	
	CustomHttpResponse edit(SubProduct subProduct);
<<<<<<< HEAD
<<<<<<< HEAD

	List<SubProduct> getAllSubProducts();

}


=======
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
	
	List<SubProduct> getAllSubProducts();

}
<<<<<<< HEAD
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
