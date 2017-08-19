<<<<<<< HEAD
<<<<<<< HEAD
package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.model.SubProduct;

import java.util.List;

@Component
@Repository("subProductDao")
public class SubProductDaoImpl extends AbstractDao<Integer, SubProduct> implements SubProductDao {

    @Override
    public List<SubProduct> getAllSubProducts() {
        Criteria c = createEntityCriteria();
        c.addOrder((Order.asc("description")));
        List<SubProduct> subProducts = (List<SubProduct>) c.list();
        return subProducts;
    }
}
=======
package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SubProductFilter;
import pe.openebusiness.ebank.model.SubProduct;

@Component
@Repository(value = "subProductDao")
public class SubProductDaoImpl extends AbstractDao<Integer, SubProduct> implements SubProductDao {

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<SubProduct> getSubProductDataTable(DataTableRequest<SubProductFilter> request) {
		Criteria criteria = createEntityCriteria();
		
		criteria.addOrder(Order.asc("sub_product_id"));

		int recordsTotal = criteria.list().size();

		int recordsFiltered = criteria.list().size();

		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());
		
		List<SubProduct> data = (List<SubProduct>) criteria.list();
		
		DataTableResponse<SubProduct> response = new DataTableResponse<SubProduct>();

		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		
		return response;
	}

	@Override
	public SubProduct getSubProductById(Integer id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("sub_product_id", id));
		
		SubProduct subProduct = (SubProduct) criteria.uniqueResult();		
		return subProduct;
	}

	@Override
	public CustomHttpResponse edit(SubProduct subProduct) {
		String action = "";

		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("sub_product_id", subProduct.getSub_product_id()));

		CustomHttpResponse response = new CustomHttpResponse();
		SubProduct _subProduct = (SubProduct) criteria.uniqueResult();

		if (subProduct.getSub_product_id() != null) {
			if (_subProduct == null) {
				response.setStatusCode(400);
				response.setMessage("Product not found");

				return response;
			} else {
				_subProduct.setDescription(subProduct.getDescription());
				_subProduct.setShort_description(subProduct.getShort_description());
				_subProduct.setProduct(subProduct.getProduct());
				_subProduct.setValidity_start(subProduct.getValidity_start());
				_subProduct.setValidity_end(subProduct.getValidity_end());

				try {
					update(_subProduct);
					action = "edited";
				} catch (Exception ex) {
					response.setStatusCode(500);
					response.setMessage(ex.getMessage());
					response.setStackTrace(ex.getStackTrace());

					return response;
				}
			}
		} else {
			try {
				persist(subProduct);

				action = "saved";
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());

				return response;
			}
		}

		response.setStatusCode(200);
		response.setMessage("Sub Product " + action);

		return response;
	}

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
=======
package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SubProductFilter;
import pe.openebusiness.ebank.model.SubProduct;

@Component
@Repository(value = "subProductDao")
public class SubProductDaoImpl extends AbstractDao<Integer, SubProduct> implements SubProductDao {

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<SubProduct> getSubProductDataTable(DataTableRequest<SubProductFilter> request) {
		Criteria criteria = createEntityCriteria();
		
		criteria.addOrder(Order.asc("sub_product_id"));

		int recordsTotal = criteria.list().size();

		int recordsFiltered = criteria.list().size();

		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());
		
		List<SubProduct> data = (List<SubProduct>) criteria.list();
		
		DataTableResponse<SubProduct> response = new DataTableResponse<SubProduct>();

		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		
		return response;
	}

	@Override
	public SubProduct getSubProductById(Integer id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("sub_product_id", id));
		
		SubProduct subProduct = (SubProduct) criteria.uniqueResult();		
		return subProduct;
	}

	@Override
	public CustomHttpResponse edit(SubProduct subProduct) {
		String action = "";

		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("sub_product_id", subProduct.getSub_product_id()));

		CustomHttpResponse response = new CustomHttpResponse();
		SubProduct _subProduct = (SubProduct) criteria.uniqueResult();

		if (subProduct.getSub_product_id() != null) {
			if (_subProduct == null) {
				response.setStatusCode(400);
				response.setMessage("Product not found");

				return response;
			} else {
				_subProduct.setDescription(subProduct.getDescription());
				_subProduct.setShort_description(subProduct.getShort_description());
				_subProduct.setProduct(subProduct.getProduct());
				_subProduct.setValidity_start(subProduct.getValidity_start());
				_subProduct.setValidity_end(subProduct.getValidity_end());

				try {
					update(_subProduct);
					action = "edited";
				} catch (Exception ex) {
					response.setStatusCode(500);
					response.setMessage(ex.getMessage());
					response.setStackTrace(ex.getStackTrace());

					return response;
				}
			}
		} else {
			try {
				persist(subProduct);

				action = "saved";
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());

				return response;
			}
		}

		response.setStatusCode(200);
		response.setMessage("Sub Product " + action);

		return response;
	}

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
