package pe.openebusiness.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.AccountFilter;
import pe.openebusiness.ebank.model.Account;
import pe.openebusiness.ebank.model.Product;
import pe.openebusiness.ebank.model.SubProduct;
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

    @RequestMapping(value = "getAccountDataTableByClientId")
    private DataTableResponse<Account> getAccountDataTableByClientId(DataTableRequest<AccountFilter> request, Integer clientId) {
        DataTableResponse<Account> response = accountService.getAccountDataTableByClientId(request, clientId);
        return response;
    }

    @RequestMapping(value = "getAllProducts")
    private List<Product> getAllProducts(){
        return accountService.getAllProducts();
    }

    @RequestMapping(value = "getAllSubProducts")
    private List<SubProduct> getAllSubProducts(){
        return accountService.getAllSubProducts();
    }

    @RequestMapping(value = "editAccount", method = RequestMethod.POST)
    private CustomHttpResponse editAccount(Account account){
        CustomHttpResponse response = accountService.edit(account);
        return response;
    }
}
