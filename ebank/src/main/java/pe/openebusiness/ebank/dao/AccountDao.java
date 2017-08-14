package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.model.Account;

import java.util.List;

public interface AccountDao {

    //Account findAccountByClientId(Integer clientId);
    Account findAccountDetailByAccountId(Integer accountId);
    List<Account> getAllAccountByClientId(Integer clientId);
}
