package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
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

    @Override
    public List<Account> getAllAccountByClientId(Integer clientId) {
        Criteria c = createEntityCriteria();
        c.addOrder(Order.asc("account_id"));
        List<Account> a = (List<Account>) c.list();
        return a;
    }
}
