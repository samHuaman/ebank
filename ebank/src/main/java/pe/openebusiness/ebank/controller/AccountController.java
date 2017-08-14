package pe.openebusiness.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.openebusiness.ebank.model.Account;
import pe.openebusiness.ebank.service.AccountService;

import java.util.List;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    AccountService accountService;

    //PG
    @ResponseBody
    @RequestMapping(value = "getAccountDetailByAccountId")
    private Account findAccountDetailByAccountId(Integer accountId) {
        Account a = accountService.findAccountDetailByAccountId(accountId);
        return a;
    }

    @RequestMapping(value = "getAllAccountByClientId")
    private List<Account> getAllAccountByClientId(Integer clientId){
        return accountService.getAllAccountByClientId(clientId);
    }
}
