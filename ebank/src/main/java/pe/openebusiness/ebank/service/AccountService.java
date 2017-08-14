package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.model.Account;

import java.util.List;

public interface AccountService {

    Account findAccountDetailByAccountId(Integer accountId);
    List<Account> getAllAccountByClientId(Integer clientId);
}
