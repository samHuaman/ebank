package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.AccountStatusFilter;
import pe.openebusiness.ebank.filter.QuotaFilter;
import pe.openebusiness.ebank.model.AccountStatus;
import pe.openebusiness.ebank.model.Quota;

public interface AccountStatusService {

    DataTableResponse<AccountStatus> getAccountStatusDataTableByAccountId(DataTableRequest<AccountStatusFilter> request, Integer accountId);
    DataTableResponse<Quota> getQuotaDataTableByScheduleId(DataTableRequest<QuotaFilter> request, Integer scheduleId);
}
