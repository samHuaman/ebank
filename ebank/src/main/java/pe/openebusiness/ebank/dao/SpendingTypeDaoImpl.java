<<<<<<< HEAD
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
import pe.openebusiness.ebank.filter.SpendingTypeFilter;
import pe.openebusiness.ebank.model.SpendingType;

@Component
@Repository(value = "spendingTypeDao")
public class SpendingTypeDaoImpl extends AbstractDao<Integer, SpendingType> implements SpendingTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SpendingType> getAllSpendingTypes() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<SpendingType> spendingTypes = (List<SpendingType>) criteria.list();
		return spendingTypes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<SpendingType> getSpendingTypeDataTable(DataTableRequest<SpendingTypeFilter> request) {
		Criteria criteria = createEntityCriteria();
		
		criteria.addOrder(Order.asc("type_id"));
		
		int recordsTotal = criteria.list().size();
		
		int recordsFiltered = criteria.list().size();
		
		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());
		
		List<SpendingType> data = (List<SpendingType>) criteria.list();
		
		DataTableResponse<SpendingType> response = new DataTableResponse<SpendingType>();
		
		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
				
		return response;
	}

	@Override
	public SpendingType getSpendingTypeById(Integer id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("type_id", id));
		
		SpendingType spendingType = (SpendingType) criteria.uniqueResult();
		return spendingType;
	}

	@Override
	public CustomHttpResponse edit(SpendingType spendingType) {
		String action = "";

		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("type_id", spendingType.getType_id()));

		CustomHttpResponse response = new CustomHttpResponse();
		SpendingType _spendingType = (SpendingType) criteria.uniqueResult();

		if (spendingType.getType_id() != null) {
			if (_spendingType == null) {
				response.setStatusCode(400);
				response.setMessage("Spending Type not found");

				return response;
			} else {
				_spendingType.setDescription(spendingType.getDescription());
				_spendingType.setShort_description(spendingType.getShort_description());
				_spendingType.setCurrency(spendingType.getCurrency());				
				_spendingType.setMin_amount(spendingType.getMin_amount());
				_spendingType.setMax_amount(spendingType.getMax_amount());
				_spendingType.setStatus(spendingType.getStatus());
				_spendingType.setGroupType(spendingType.getGroupType());

				try {
					update(_spendingType);
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
				persist(spendingType);
				action = "saved";
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());

				return response;
			}
		}

		response.setStatusCode(200);
		response.setMessage("Spending Type " + action);

		return response;
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
import pe.openebusiness.ebank.filter.SpendingTypeFilter;
import pe.openebusiness.ebank.model.SpendingType;

@Component
@Repository(value = "spendingTypeDao")
public class SpendingTypeDaoImpl extends AbstractDao<Integer, SpendingType> implements SpendingTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SpendingType> getAllSpendingTypes() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<SpendingType> spendingTypes = (List<SpendingType>) criteria.list();
		return spendingTypes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponse<SpendingType> getSpendingTypeDataTable(DataTableRequest<SpendingTypeFilter> request) {
		Criteria criteria = createEntityCriteria();
		
		criteria.addOrder(Order.asc("type_id"));
		
		int recordsTotal = criteria.list().size();
		
		int recordsFiltered = criteria.list().size();
		
		criteria.setFirstResult(request.getStart());
		criteria.setMaxResults(request.getLength());
		
		List<SpendingType> data = (List<SpendingType>) criteria.list();
		
		DataTableResponse<SpendingType> response = new DataTableResponse<SpendingType>();
		
		response.setData(data);
		response.setDraw(request.getDraw());
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
				
		return response;
	}

	@Override
	public SpendingType getSpendingTypeById(Integer id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("type_id", id));
		
		SpendingType spendingType = (SpendingType) criteria.uniqueResult();
		return spendingType;
	}

	@Override
	public CustomHttpResponse edit(SpendingType spendingType) {
		String action = "";

		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("type_id", spendingType.getType_id()));

		CustomHttpResponse response = new CustomHttpResponse();
		SpendingType _spendingType = (SpendingType) criteria.uniqueResult();

		if (spendingType.getType_id() != null) {
			if (_spendingType == null) {
				response.setStatusCode(400);
				response.setMessage("Spending Type not found");

				return response;
			} else {
				_spendingType.setDescription(spendingType.getDescription());
				_spendingType.setShort_description(spendingType.getShort_description());
				_spendingType.setCurrency(spendingType.getCurrency());				
				_spendingType.setMin_amount(spendingType.getMin_amount());
				_spendingType.setMax_amount(spendingType.getMax_amount());
				_spendingType.setStatus(spendingType.getStatus());
				_spendingType.setGroupType(spendingType.getGroupType());

				try {
					update(_spendingType);
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
				persist(spendingType);
				action = "saved";
			} catch (Exception ex) {
				response.setStatusCode(500);
				response.setMessage(ex.getMessage());
				response.setStackTrace(ex.getStackTrace());

				return response;
			}
		}

		response.setStatusCode(200);
		response.setMessage("Spending Type " + action);

		return response;
	}
	
}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
