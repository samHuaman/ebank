package pe.openebusiness.ebank.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.WarrantyFilter;
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

        criteria.add(Restrictions.eq("warranty_id", warrantyId));

        Warranty warratyDetail = (Warranty) criteria.uniqueResult();
        return warratyDetail;
    }

    @Override
    public DataTableResponse<Warranty> getWarrantyDataTableByClientId(DataTableRequest<WarrantyFilter> request, Integer clientId) {

        Criteria c = createEntityCriteria();
        c.add(Restrictions.eq("client_id.client_id", clientId));

//        c.addOrder(Order.asc("account_id"));
//        c.addOrder(Order.asc("number_quotas"));
//        c.addOrder(Order.asc("sub_product_id"));
//        c.addOrder(Order.asc("AMOUNT_DISBURSED"));
//        c.addOrder(Order.asc("AMOUNT"));
//        c.addOrder(Order.asc("CURRENCY_TYPE_ID"));

        int recordsTotal = c.list().size();

        int recordsFiltered = c.list().size();

        c.setFirstResult(request.getStart());
        c.setMaxResults(request.getLength());

        List<Warranty> data = (List<Warranty>) c.list();

        DataTableResponse<Warranty> response = new DataTableResponse<Warranty>();

        response.setData(data);
        response.setDraw(request.getDraw());
        response.setRecordsFiltered(recordsFiltered);;
        response.setRecordsTotal(recordsTotal);

        return response;
    }

    @Override
    public CustomHttpResponse edit(Warranty warranty) {

        Criteria c = createEntityCriteria();
        c.add(Restrictions.eq("warranty_id", warranty.getWarranty_id()));

        CustomHttpResponse response = new CustomHttpResponse();
        Warranty w = (Warranty) c.uniqueResult();

        if(w == null){
            response.setStatusCode(400);
            response.setMessage("Warranty not found");
            return response;
        }
        else {
            w.setWarranty_id(warranty.getWarranty_id());
//            w.setWarranty_type_id(warranty.getWarranty_type_id());
//            w.setAssest_type_id(warranty.getAssest_type_id());
            w.setDdescription(warranty.getDdescription());
            w.setAaddress(warranty.getAaddress());
            w.setAmount_assessed(warranty.getAmount_assessed());
            w.setPublic_record_number(warranty.getPublic_record_number());

            try{
                update(w);
            }catch(Exception e){
                response.setStatusCode(500);
                response.setMessage(e.getMessage());
                response.setStackTrace(e.getStackTrace());
                return response;
            }
            response.setStatusCode(200);
            response.setMessage("Warranty edited");
        }
        return response;
    }


}
