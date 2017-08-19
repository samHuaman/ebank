package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.MovementFilter;
import pe.openebusiness.ebank.model.Movement;

@Component
@Repository(value = "movementDao")
public class MovementDaoImpl extends AbstractDao<Integer, Movement> implements MovementDao {

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<Movement> getMovemetDataTableByAccount(DataTableRequest<MovementFilter> request,
			Integer account_id) {
		Criteria criteria = createEntityCriteria();
		
		criteria.add(Restrictions.eq("account.account_id", account_id));
		criteria.addOrder(Order.asc("movement_id"));
		
		int recordsTotal = criteria.list().size();

		int recordsFiltered = criteria.list().size();

		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());
		
		List<Movement> data = (List<Movement>) criteria.list();
		
		DataTableResponse<Movement> response = new DataTableResponse<Movement>();	
		
		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);

		return response;
	}

}
