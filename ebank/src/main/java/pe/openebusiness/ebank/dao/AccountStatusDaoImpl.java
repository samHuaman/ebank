package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.AccountStatusFilter;
import pe.openebusiness.ebank.model.AccountStatus;

import java.util.List;

@Component
@Repository("accountStatusDao")
public class AccountStatusDaoImpl extends AbstractDao<Integer,AccountStatus> implements AccountStatusDao {

    @SuppressWarnings("unchecked")
    @Override
    public DataTableResponse<AccountStatus> getAccountStatusDataTableByAccountId(DataTableRequest<AccountStatusFilter> request, Integer accountId) {

        Criteria c = createEntityCriteria();
        c.add(Restrictions.eq("account_id.account_id", accountId));

        int recordsTotal = c.list().size();
        int recordsFiltered = c.list().size();

        c.setFirstResult(request.getStart());
        c.setMaxResults(request.getLength());

        List<AccountStatus> data = (List<AccountStatus>) c.list();
        DataTableResponse<AccountStatus> response  = new DataTableResponse<>();
        response.setData(data);
        response.setDraw(request.getDraw());
        response.setRecordsFiltered(recordsFiltered);;
        response.setRecordsTotal(recordsTotal);

       return response;
    }
}
