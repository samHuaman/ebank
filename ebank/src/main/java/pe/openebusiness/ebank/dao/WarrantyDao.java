package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.model.Warranty;

import java.util.List;

public interface WarrantyDao {

    List<Warranty> findWarrantyCustomerById (Integer customerId);

    List<Warranty> getAllWarrantyCustomerById(Integer customerId);

    Warranty findWarrantyDetailById (Integer warrantyId);
}
