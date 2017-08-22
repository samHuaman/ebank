package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.QuotaFilter;
import pe.openebusiness.ebank.model.Quota;

import java.util.List;

@Component
@Repository("quotaDao")
public class QuotaDaoImpl extends AbstractDao<Integer, Quota> implements QuotaDao {


    @SuppressWarnings("unchecked")
	@Override
    public DataTableResponse<Quota> getQuotaDataTableByScheduleId(DataTableRequest<QuotaFilter> request, Integer scheduleId) {

        Criteria c = createEntityCriteria();
        c.add(Restrictions.eq("schedule_id", scheduleId));

//        c.addOrder(Order.asc("account_id"));
//        c.addOrder(Order.asc("number_quotas"));
//        c.addOrder(Order.asc("sub_product_id"));
//        c.addOrder(Order.asc("AMOUNT_DISBURSED"));
//        c.addOrder(Order.asc("AMOUNT"));
//        c.addOrder(Order.asc("CURRENCY_TYPE_ID"));

        int recordsTotal = c.list().size();

        int recordsFiltered = c.list().size();

        c.setFirstResult(request.getStart());
        c.setMaxResults(request.getLength());

        List<Quota> data = (List<Quota>) c.list();

        DataTableResponse<Quota> response = new DataTableResponse<Quota>();

        response.setData(data);
        response.setDraw(request.getDraw());
        response.setRecordsFiltered(recordsFiltered);;
        response.setRecordsTotal(recordsTotal);

        return response;
    }
}
