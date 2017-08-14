package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.model.AssestType;

import java.util.List;

@Component
@Repository("assestTypeDao")
public class AssestTypeDaoImpl extends AbstractDao<Integer,AssestType> implements AssestTypeDao {

    @SuppressWarnings("unchecked")
	@Override
    public List<AssestType> getAllAssestType() {

        Criteria criteria = createEntityCriteria();
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("assest_type_id"),"assest_type_id")
            .add(Projections.property("ddescription"),"ddescription"))
                    .setResultTransformer(Transformers.aliasToBean(AssestType.class));

        criteria.addOrder(Order.asc("ddescription"));
        List<AssestType> assestTypes = (List<AssestType>) criteria.list();
        return assestTypes;
    }
}
