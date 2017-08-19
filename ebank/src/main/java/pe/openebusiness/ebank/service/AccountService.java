package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.AccountFilter;
import pe.openebusiness.ebank.model.Account;
import pe.openebusiness.ebank.model.Product;
import pe.openebusiness.ebank.model.SubProduct;

import java.util.List;

public interface AccountService {

    Account findAccountDetailByAccountId(Integer accountId);
    List<Account> getAllAccountByClientId(Integer clientId);

    public DataTableResponse<Account> getAccountDataTableByClientId(DataTableRequest<AccountFilter> request, Integer clientId);

    List<Product> getAllProducts();

    List<SubProduct> getAllSubProducts();
    public CustomHttpResponse edit (Account account);
}
