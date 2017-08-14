package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.model.Warranty;

import java.util.List;


@Component
@Repository("warrantyDao")
public class WarrantyDaoImpl extends  AbstractDao<Integer, Warranty> implements  WarrantyDao {

    @SuppressWarnings("unchecked")
	@Override
    public List<Warranty> findWarrantyCustomerById(Integer customerId) {

        Criteria criteria = createEntityCriteria();
        criteria
                .setProjection(Projections.projectionList()
                    .add(Projections.property("customer_type"), "customer_type")
                    .add(Projections.property("customer_id"), "customer_id")
                    .add(Projections.property("customer"), "customer")
                    .add(Projections.property("amount_assessed"), "amount_assessed")
                )
                .setResultTransformer(Transformers.aliasToBean(Warranty.class));
        criteria.add(Restrictions.eq("customer_id", customerId));
        List<Warranty> warrantys = (List<Warranty>) criteria.list();
        return warrantys;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Warranty> getAllWarrantyCustomerById(Integer customerId){

        Criteria criteria = createEntityCriteria();
//        criteria.setProjection(Projections.projectionList()
//                .add(Projections.property("warranty_id"),"warranty_id")
//                .add(Projections.property("customer_type"), "customer_type")
//                .add(Projections.property("customer_id"), "customer_id")
//                .add(Projections.property("customer"), "customer")
//                .add(Projections.property("total_assessed"), "total_assessed")
//                .add(Projections.property("warranty_type"), "warranty_type")
//                .add(Projections.property("assest_type"), "assest_type")
//                .add(Projections.property("ddescription"), "ddescription")
//                .add(Projections.property("aaddress"), "aaddress")
//                .add(Projections.property("public_record_number"), "public_record_number")
//                .add(Projections.property("amount_assessed"), "amount_assessed")
//                .add(Projections.property("policy"), "policy"))
//                .setResultTransformer(Transformers.aliasToBean(Warranty.class));
        criteria.addOrder(Order.asc("warranty_id"));
        List<Warranty> warrantys = (List<Warranty>) criteria.list();
        return warrantys;
    }

    @Override
    public Warranty findWarrantyDetailById(Integer warrantyId) {

        Criteria criteria = createEntityCriteria();
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("warranty_id"),"warranty_id")
                .add(Projections.property("customer_type"), "customer_type")
                .add(Projections.property("customer_id"), "customer_id")
                .add(Projections.property("customer"), "customer")
                .add(Projections.property("total_assessed"), "total_assessed")
                .add(Projections.property("warranty_type"), "warranty_type")
                .add(Projections.property("assest_type"), "assest_type")
                .add(Projections.property("ddescription"), "ddescription")
                .add(Projections.property("aaddress"), "aaddress")
                .add(Projections.property("public_record_number"), "public_record_number")
                .add(Projections.property("amount_assessed"), "amount_assessed")
                .add(Projections.property("policy"), "policy"))
                .setResultTransformer(Transformers.aliasToBean(Warranty.class));

        criteria.add(Restrictions.eq("warranty_id", warrantyId));

        Warranty warratyDetail = (Warranty) criteria.uniqueResult();
        return warratyDetail;
    }


}
