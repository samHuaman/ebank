package pe.openebusiness.ebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.dao.AccountDao;
import pe.openebusiness.ebank.dao.ProductDao;
import pe.openebusiness.ebank.dao.SubProductDao;
import pe.openebusiness.ebank.filter.AccountFilter;
import pe.openebusiness.ebank.model.Account;
import pe.openebusiness.ebank.model.Product;
import pe.openebusiness.ebank.model.SubProduct;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SubProductDao subProductDao;

    @Override
    public Account findAccountDetailByAccountId(Integer accountId) {
        return accountDao.findAccountDetailByAccountId(accountId);
    }

    @Override
    public List<Account> getAllAccountByClientId(Integer clientId) {
        return  accountDao.getAllAccountByClientId(clientId);
    }

    @Override
    public DataTableResponse<Account> getAccountDataTableByClientId(DataTableRequest<AccountFilter> request, Integer clientId) {
        return accountDao.getAccountDataTableByClientId(request,clientId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public List<SubProduct> getAllSubProducts() {
        return subProductDao.getAllSubProducts();
    }

    @Override
    public CustomHttpResponse edit(Account account) {
        return accountDao.edit(account);
    }
}
