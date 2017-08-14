package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.SectorType;

@Component
@Repository(value = "sectorTypeDao")
public class SectorTypeDaoImpl extends AbstractDao<Integer, SectorType> implements SectorTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SectorType> getAllSectorTypes() {
		Criteria criteria = createEntityCriteria();
		List<SectorType> sectorTypes = (List<SectorType>) criteria.list();
		
		return sectorTypes;
	}

}
