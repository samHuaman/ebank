package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.AccountStatusFilter;
import pe.openebusiness.ebank.model.AccountStatus;

public interface AccountStatusDao {
    DataTableResponse<AccountStatus> getAccountStatusDataTableByAccountId(DataTableRequest<AccountStatusFilter> request, Integer accountId);
}
