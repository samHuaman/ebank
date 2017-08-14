package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.ProductType;

@Component
@Repository(value = "productTypeDao")
public class ProductTypeDaoImpl extends AbstractDao<Integer, ProductType> implements ProductTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> getAllProductType() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<ProductType> productTypes = (List<ProductType>) criteria.list();
		return productTypes;
	}

}
