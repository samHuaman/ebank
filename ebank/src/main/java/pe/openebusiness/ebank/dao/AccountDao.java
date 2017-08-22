package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.AccountFilter;
import pe.openebusiness.ebank.model.Account;

import java.util.List;

public interface AccountDao {

    //Account findAccountByClientId(Integer clientId);
    Account findAccountDetailByAccountId(Integer accountId);
    List<Account> getAllAccountByClientId(Integer clientId);
    DataTableResponse<Account> getAccountDataTableByClientId(DataTableRequest<AccountFilter> request, Integer clientId);
    CustomHttpResponse edit (Account account);
}
