package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.AccountFilter;
import pe.openebusiness.ebank.model.Account;

import java.util.List;

@Component
@Repository("accountDao")
public class AccountDaoImpl extends AbstractDao<Integer,Account> implements AccountDao {


    @Override
    public Account findAccountDetailByAccountId(Integer accountId) {
        Criteria c = createEntityCriteria();
        c.add(Restrictions.eq("account_id",accountId));

        Account a = (Account) c.uniqueResult();
        return a;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Account> getAllAccountByClientId(Integer clientId) {
        Criteria c = createEntityCriteria();
        c.addOrder(Order.asc("account_id"));
        List<Account> a = (List<Account>) c.list();
        return a;
    }

    @SuppressWarnings("unchecked")
    @Override
    public DataTableResponse<Account> getAccountDataTableByClientId(DataTableRequest<AccountFilter> request, Integer clientId) {

        Criteria c = createEntityCriteria();
        c.add(Restrictions.eq("client_id.client_id", clientId));

        c.addOrder(Order.asc("account_id"));
        c.addOrder(Order.asc("number_quotas"));
        c.addOrder(Order.asc("sub_product_id"));
        c.addOrder(Order.asc("AMOUNT_DISBURSED"));
        c.addOrder(Order.asc("AMOUNT"));
        c.addOrder(Order.asc("CURRENCY_TYPE_ID"));

        int recordsTotal = c.list().size();

        int recordsFiltered = c.list().size();

        c.setFirstResult(request.getStart());
        c.setMaxResults(request.getLength());

        List<Account> data = (List<Account>) c.list();

        DataTableResponse<Account> response = new DataTableResponse<Account>();

        response.setData(data);
        response.setDraw(request.getDraw());
        response.setRecordsFiltered(recordsFiltered);;
        response.setRecordsTotal(recordsTotal);

        return response;
    }

    @Override
    public CustomHttpResponse edit(Account account) {
        Criteria c = createEntityCriteria();
        c.add(Restrictions.eq("account_id", account.getAccount_id()));

        CustomHttpResponse response = new CustomHttpResponse();
        Account a = (Account) c.uniqueResult();

        if(a == null){
            response.setStatusCode(400);
            response.setMessage("Account not found");
            return response;
        }
        else{
           a.setAccount_id(account.getAccount_id());
           a.setAaccount(account.getAaccount());
           a.setProduct_id(account.getProduct_id());
           a.setSub_product_id(account.getSub_product_id());
           a.setDisbur_date(account.getDisbur_date());
           a.setCURRENCY_TYPE_ID(account.getCURRENCY_TYPE_ID());
           a.setAmount_requested(account.getAmount_requested());
           a.setPayment_priority(account.getPayment_priority());
           a.setNumber_quotas(account.getNumber_quotas());
           a.setPayday(account.getPayday());
           a.setTotal_length(account.getTotal_length());
           a.setInterest_rate_mora(account.getInterest_rate_mora());
           a.setAn_effe_compe_inte_rate(account.getAn_effe_compe_inte_rate());
           a.setTota_compe_inte(account.getTota_compe_inte());
           a.setComm_for_oper_expen(account.getComm_for_oper_expen());
           a.setInsurance(account.getInsurance());
           a.setTotal_debt(account.getTotal_debt());

           try{
               update(a);
           } catch (Exception e){
               response.setStatusCode(500);
               response.setMessage(e.getMessage());
               response.setStackTrace(e.getStackTrace());
               return response;
           }
            response.setStatusCode(200);
           response.setMessage("Account edited");
        }
        return response;
    }
}
