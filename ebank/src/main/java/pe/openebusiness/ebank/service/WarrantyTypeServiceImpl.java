package pe.openebusiness.ebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.openebusiness.ebank.dao.WarrantyTypeDao;
import pe.openebusiness.ebank.model.WarrantyType;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Service("warrantyTypeService")
@Transactional
public class WarrantyTypeServiceImpl implements WarrantyTypeService {

    @Autowired
    private WarrantyTypeDao dao;

    @Override
    public List<WarrantyType> getAllWarrantyType() {
        return dao.getAllWarrantyType();
    }
}
