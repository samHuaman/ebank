package pe.openebusiness.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.WarrantyFilter;
import pe.openebusiness.ebank.model.AssestType;
import pe.openebusiness.ebank.model.Warranty;
import pe.openebusiness.ebank.model.WarrantyType;
import pe.openebusiness.ebank.service.AssestTypeService;
import pe.openebusiness.ebank.service.WarrantyService;
import pe.openebusiness.ebank.service.WarrantyTypeService;

import java.util.List;

@RestController
@RequestMapping(value = "warranty")
public class WarrantyController {

    @Autowired
    WarrantyService warrantyService;

    @Autowired
    WarrantyTypeService warrantyTypeService;

    @Autowired
    AssestTypeService assestTypeService;

    @RequestMapping(value = "getWarrantyById")
    private List<Warranty> findWarrantyCustomerById(int customerId){
        return warrantyService.findWarrantyCustomerById(customerId);

    }

    @RequestMapping(value = "getAllWarrantyById")
    private List<Warranty> getAllWarrantyCustomerById(int customerId){
        return warrantyService.getAllWarrantyCustomerById(customerId);
    }

    @RequestMapping(value = "getWarrantyDetailById")
    private Warranty findWarrantyDetailById(int warrantyId){
        return warrantyService.findWarrantyDetailById(warrantyId);
    }

    @RequestMapping(value = "getAllWarrantyType")
    private List<WarrantyType> getAllWarrantyType(){
        return warrantyTypeService.getAllWarrantyType();
    }

    @RequestMapping(value = "getAllAssestType")
    private List<AssestType> getAllAssestType(){
        return assestTypeService.getAllAssestType();
    }

    @RequestMapping(value = "getWarrantyDataTableByClientId")
    private DataTableResponse<Warranty> getAccountDataTableByClientId(DataTableRequest<WarrantyFilter> request, Integer clientId) {
        DataTableResponse<Warranty> response = warrantyService.getWarrantyDataTableByClientId(request, clientId);
        return response;
    }

    @RequestMapping(value = "editWarranty", method = RequestMethod.POST)
    private CustomHttpResponse editWarranty(Warranty warranty){
        CustomHttpResponse response = warrantyService.edit(warranty);
        return response;
    }

}
