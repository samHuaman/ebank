package pe.openebusiness.ebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.openebusiness.ebank.dao.AccountDao;
import pe.openebusiness.ebank.model.Account;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountDetailByAccountId(Integer accountId) {
        return accountDao.findAccountDetailByAccountId(accountId);
    }

    @Override
    public List<Account> getAllAccountByClientId(Integer clientId) {
        return  accountDao.getAllAccountByClientId(clientId);
    }
}
