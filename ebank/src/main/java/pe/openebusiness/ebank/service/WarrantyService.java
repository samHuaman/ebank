package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.model.Warranty;

import java.util.List;

public interface WarrantyService {

    List<Warranty> findWarrantyCustomerById (Integer customerId);

    List<Warranty> getAllWarrantyCustomerById(Integer customerId);

    Warranty findWarrantyDetailById (Integer warrantyId);
}
