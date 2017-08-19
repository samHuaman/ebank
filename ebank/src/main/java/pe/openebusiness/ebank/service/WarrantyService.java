package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.WarrantyFilter;
import pe.openebusiness.ebank.model.Warranty;

import java.util.List;

public interface WarrantyService {

    List<Warranty> findWarrantyCustomerById (Integer customerId);

    List<Warranty> getAllWarrantyCustomerById(Integer customerId);

    Warranty findWarrantyDetailById (Integer warrantyId);

    public DataTableResponse<Warranty> getWarrantyDataTableByClientId(DataTableRequest<WarrantyFilter> request, Integer clientId);

    public CustomHttpResponse edit (Warranty warranty);
}
