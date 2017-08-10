package pe.openebusiness.ebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.openebusiness.ebank.dao.AssestTypeDao;
import pe.openebusiness.ebank.model.AssestType;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Service("assestTypeService")
@Transactional
public class AssestTypeServiceImpl implements AssestTypeService {

    @Autowired
    private AssestTypeDao dao;

    @Override
    public List<AssestType> getAllAssestType() {
        return dao.getAllAssestType();
    }
}
