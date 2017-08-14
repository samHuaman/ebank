package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.model.WarrantyType;

import java.util.List;

@Component
@Repository("warrantyTypeDao")
public class WarrantyTypeDaoImpl extends AbstractDao<Integer, WarrantyType> implements WarrantyTypeDao {


    @Override
    public List<WarrantyType> getAllWarrantyType() {

        Criteria criteria = createEntityCriteria();
        criteria.setProjection(Projections.projectionList()
           .add(Projections.property("warranty_type_id"),"warranty_type_id")
           .add(Projections.property("ddescription"),"ddescription"))
           .setResultTransformer(Transformers.aliasToBean(WarrantyType.class));

        criteria.addOrder(Order.asc("ddescription"));
        List<WarrantyType> warrantysType = (List<WarrantyType>) criteria.list();
        return warrantysType;
    }
}
