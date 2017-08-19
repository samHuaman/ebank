package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.WarrantyFilter;
import pe.openebusiness.ebank.model.Warranty;

import java.util.List;

public interface WarrantyDao {

    List<Warranty> findWarrantyCustomerById (Integer customerId);

    List<Warranty> getAllWarrantyCustomerById(Integer customerId);

    Warranty findWarrantyDetailById (Integer warrantyId);

    DataTableResponse<Warranty> getWarrantyDataTableByClientId(DataTableRequest<WarrantyFilter> request, Integer clientId);

    CustomHttpResponse edit (Warranty warranty);
}
