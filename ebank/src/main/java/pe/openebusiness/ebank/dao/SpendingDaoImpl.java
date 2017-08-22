<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.model.Spending;

@Component
@Repository(value = "spendingDao")
public class SpendingDaoImpl extends AbstractDao<Integer, Spending> implements SpendingDao {

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<Spending> getSpendingDataTableByClient(DataTableRequest<SpendingFilter> request, Integer client_id) {
		Criteria criteria = createEntityCriteria();
		
		criteria.add(Restrictions.eq("client.client_id", client_id));
		criteria.addOrder(Order.asc("spending_id"));
		
		int recordsTotal = criteria.list().size();
		
		int recordsFiltered = criteria.list().size();
		
		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());

		List<Spending> data = (List<Spending>) criteria.list();
		
		DataTableResponse<Spending> response = new DataTableResponse<Spending>();
		
		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
				
		return response;
	}

}
<<<<<<< HEAD
=======
package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.SpendingFilter;
import pe.openebusiness.ebank.model.Spending;

@Component
@Repository(value = "spendingDao")
public class SpendingDaoImpl extends AbstractDao<Integer, Spending> implements SpendingDao {

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<Spending> getSpendingDataTableByClient(DataTableRequest<SpendingFilter> request, Integer client_id) {
		Criteria criteria = createEntityCriteria();
		
		criteria.add(Restrictions.eq("client.client_id", client_id));
		criteria.addOrder(Order.asc("spending_id"));
		
		int recordsTotal = criteria.list().size();
		
		int recordsFiltered = criteria.list().size();
		
		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());

		List<Spending> data = (List<Spending>) criteria.list();
		
		DataTableResponse<Spending> response = new DataTableResponse<Spending>();
		
		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
				
		return response;
	}

}
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
