<<<<<<< HEAD

package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.FeeFilter;
import pe.openebusiness.ebank.model.Fee;

@Component
@Repository(value = "feeDao")
public class FeeDaoImpl extends AbstractDao<Integer, Fee> implements FeeDao {

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
import pe.openebusiness.ebank.constant.Alias;
import pe.openebusiness.ebank.filter.FeeFilter;
import pe.openebusiness.ebank.model.Fee;

@Component
@Repository(value = "feeDao")
public class FeeDaoImpl extends AbstractDao<Integer, Fee> implements FeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<Fee> getFeeDataTable(DataTableRequest<FeeFilter> request, Integer schedule_id) {
		Criteria criteria = createEntityCriteria();
		
		criteria.add(Restrictions.eq("schedule.schedule_id", schedule_id));
		criteria.addOrder(Order.asc("fee_number"));
		
		int recordsTotal = criteria.list().size();
		
		if (request.getFilter() != null) {
			if (request.getFilter().getScheduleRegistrationDate() != null) {
				criteria.add(Restrictions.eq("schedule.registration_date", request.getFilter().getScheduleRegistrationDate()));
			}
		}

		int recordsFiltered = criteria.list().size();
		
		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());
		
		List<Fee> data = (List<Fee>) criteria.list();
		
		DataTableResponse<Fee> response = new DataTableResponse<Fee>();
		
		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
				
		return response;
	}

>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
	@SuppressWarnings("unchecked")
	@Override
	public List<Fee> getPendingFees(Integer schedule_id) {
		Criteria criteria = createEntityCriteria();
		
		criteria.add(Restrictions.eq("schedule.schedule_id", schedule_id));
		
		criteria.createAlias("feeStatus", "status");
		criteria.add(Restrictions.eq("status.alias", Alias.FEE_NO_PAID));
		
		criteria.addOrder(Order.asc("fee_number"));
		
		List<Fee> fees = (List<Fee>) criteria.list();
		return fees;
	}

<<<<<<< HEAD
}
=======
}

>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
