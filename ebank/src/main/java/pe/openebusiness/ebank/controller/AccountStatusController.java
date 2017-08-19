package pe.openebusiness.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.AccountStatusFilter;
import pe.openebusiness.ebank.filter.QuotaFilter;
import pe.openebusiness.ebank.model.AccountStatus;
import pe.openebusiness.ebank.model.Quota;
import pe.openebusiness.ebank.service.AccountStatusService;

@RestController
@RequestMapping(value = "accountStatus")
public class AccountStatusController {

    @Autowired
    AccountStatusService accountStatusService;

    @RequestMapping(value = "getAccountStatusDataTableByAccountId")
    private DataTableResponse<AccountStatus> getAccountStatusDataTableByAccountId(DataTableRequest<AccountStatusFilter> request, Integer accountId) {
        DataTableResponse<AccountStatus> response = accountStatusService.getAccountStatusDataTableByAccountId(request, accountId);
        return response;
    }

    @RequestMapping(value = "getQuotaDataTableByScheduleId")
    private DataTableResponse<Quota> getQuotaDataTableByScheduleId(DataTableRequest<QuotaFilter> request,Integer scheduleId){
        DataTableResponse<Quota> response  = accountStatusService.getQuotaDataTableByScheduleId(request, scheduleId);
        return response;
    }
}
