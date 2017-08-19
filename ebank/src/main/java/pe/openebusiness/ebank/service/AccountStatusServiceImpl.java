package pe.openebusiness.ebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.dao.AccountStatusDao;
import pe.openebusiness.ebank.dao.QuotaDao;
import pe.openebusiness.ebank.filter.AccountStatusFilter;
import pe.openebusiness.ebank.filter.QuotaFilter;
import pe.openebusiness.ebank.model.AccountStatus;
import pe.openebusiness.ebank.model.Quota;

import javax.transaction.Transactional;

@Component
@Service("accountStatusService")
@Transactional
public class AccountStatusServiceImpl implements AccountStatusService {

    @Autowired
    private AccountStatusDao asDao;

    @Autowired
    private QuotaDao quotaDao;

    @Override
    public DataTableResponse<AccountStatus> getAccountStatusDataTableByAccountId(DataTableRequest<AccountStatusFilter> request, Integer accountId) {
        return asDao.getAccountStatusDataTableByAccountId(request,accountId);
    }

    @Override
    public DataTableResponse<Quota> getQuotaDataTableByScheduleId(DataTableRequest<QuotaFilter> request, Integer scheduleId) {
        return quotaDao.getQuotaDataTableByScheduleId(request,scheduleId);
    }
}
