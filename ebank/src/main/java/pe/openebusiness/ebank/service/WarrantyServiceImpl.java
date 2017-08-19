package pe.openebusiness.ebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.WarrantyFilter;
import pe.openebusiness.ebank.service.WarrantyService;
import pe.openebusiness.ebank.dao.WarrantyDao;
import pe.openebusiness.ebank.model.Warranty;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Service("warrantyService")
@Transactional
public class WarrantyServiceImpl implements WarrantyService {

    @Autowired
    private WarrantyDao dao;

    @Override
    public List<Warranty> findWarrantyCustomerById(Integer customerId) {
        return dao.findWarrantyCustomerById(customerId);
    }

    @Override
    public List<Warranty> getAllWarrantyCustomerById(Integer customerId) {
        return dao.getAllWarrantyCustomerById(customerId);
    }

    @Override
    public Warranty findWarrantyDetailById(Integer warrantyId) {
        return dao.findWarrantyDetailById(warrantyId);
    }

    @Override
    public DataTableResponse<Warranty> getWarrantyDataTableByClientId(DataTableRequest<WarrantyFilter> request, Integer clientId) {
        return dao.getWarrantyDataTableByClientId(request,clientId);
    }

    @Override
    public CustomHttpResponse edit(Warranty warranty) {
        return dao.edit(warranty);
    }
}
