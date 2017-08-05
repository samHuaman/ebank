package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.ZoneType;

@Component
@Repository(value = "zoneTypeDao")
public class ZoneTypeDaoImpl extends AbstractDao<Integer, ZoneType> implements ZoneTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ZoneType> getAllZoneType() {
		Criteria criteria = createEntityCriteria();
		List<ZoneType> zoneTypes = (List<ZoneType>) criteria.list();
		
		return zoneTypes;
	}

}
