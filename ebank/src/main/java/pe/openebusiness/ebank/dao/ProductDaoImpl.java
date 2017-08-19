package pe.openebusiness.ebank.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.bind.Select2Response;
import pe.openebusiness.ebank.filter.ProductFilter;
import pe.openebusiness.ebank.model.Plan;
import pe.openebusiness.ebank.model.Product;
import pe.openebusiness.ebank.model.SubProduct;

@Component
@Repository(value = "productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<Product> getProductDataTable(DataTableRequest<ProductFilter> request) {
		Criteria criteria = createEntityCriteria();

		criteria.setProjection(
				Projections.projectionList().add(Projections.distinct(Projections.property("product_id")))
						.add(Projections.property("product_id"), "product_id")
						.add(Projections.property("description"), "description")
						.add(Projections.property("productType"), "productType")
						.add(Projections.property("principalCurrency"), "principalCurrency")
						.add(Projections.property("secundaryCurrency"), "secundaryCurrency")
						.add(Projections.property("validity_start"), "validity_start")
						.add(Projections.property("validity_end"), "validity_end"))
				.setResultTransformer(Transformers.aliasToBean(Product.class));

		criteria.addOrder(Order.asc("product_id"));

		int recordsTotal = criteria.list().size();

		int recordsFiltered = criteria.list().size();

		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());

		List<Product> data = (List<Product>) criteria.list();

		DataTableResponse<Product> response = new DataTableResponse<Product>();

		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);

		return response;
	}

	@Override
	public CustomHttpResponse edit(Product product, String[] plans) {
		String action = "";
		Set<Plan> _plans = new HashSet<Plan>();

		if (plans != null) {
			for (String plan : plans) {
				Plan _plan = new Plan();
				_plan.setPlan_id(Integer.parseInt(plan));
				_plans.add(_plan);
			}
		}

		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("product_id", product.getProduct_id()));

		CustomHttpResponse response = new CustomHttpResponse();
		Product _product = (Product) criteria.uniqueResult();

		if (product.getProduct_id() != null) {
			if (_product == null) {
				response.setStatusCode(400);
				response.setMessage("Product not found");

				return response;
			} else {
				_product.setDescription(product.getDescription());
				_product.setShort_description(product.getShort_description());
				_product.setProductType(product.getProductType());
				_product.setPrincipalCurrency(product.getPrincipalCurrency());
				_product.setSecundaryCurrency(product.getSecundaryCurrency());
				_product.setValidity_start(product.getValidity_start());
				_product.setValidity_end(product.getValidity_end());
				_product.setPlans(_plans);

				try {
					update(_product);
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
				product.setPlans(_plans);
				persist(product);

				action = "saved";
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());

				return response;
			}
		}

		response.setStatusCode(200);
		response.setMessage("Product " + action);

		return response;
	}

	@Override
	public Product getProductById(Integer id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("product_id", id));

		Product product = (Product) criteria.uniqueResult();

		if (product != null) {
			Hibernate.initialize(product.getPlans());
		}

		return product;
	}

<<<<<<< HEAD
	@Override
	public List<Product> getAllProducts() {
		Criteria c = createEntityCriteria();
		c.addOrder(Order.asc("description"));

		List<Product> products = (List<Product>) c.list();
		return products;
=======
	@SuppressWarnings("unchecked")
	@Override
	public Select2Response<Product> searchProducts(String query, Integer page, Integer pageLimit) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.ilike("description", query, MatchMode.ANYWHERE));
		
		Integer total = criteria.list().size();
		
		criteria.addOrder(Order.asc("description"));
		
		page -= 1;
		
		int firstResult = page * pageLimit;
		
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(pageLimit);
		
		List<Product> items = (List<Product>) criteria.list();
		
		Select2Response<Product> response = new Select2Response<Product>();
		response.setItems(items);
		response.setTotal(total);
		
		return response;
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
	}

}
