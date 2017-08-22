
package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.PaymentFilter;
import pe.openebusiness.ebank.model.Payment;

@Component
@Repository(value = "paymentDao")
public class PaymentDaoImpl extends AbstractDao<Integer, Payment> implements PaymentDao {

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<Payment> getPaymentDataTable(DataTableRequest<PaymentFilter> request) {
		Criteria criteria = createEntityCriteria();
		
		criteria.addOrder(Order.desc("payment_id"));
		
		int recordsTotal = criteria.list().size();
		
		int recordsFiltered = criteria.list().size();
		
		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());
		
		List<Payment> data = (List<Payment>) criteria.list();
		
		DataTableResponse<Payment> response = new DataTableResponse<Payment>();
		
		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
				
		return response;
	}

}