package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.RoadType;

@Component
@Repository(value = "roadTypeDao")
public class RoadTypeDaoImpl extends AbstractDao<Integer, RoadType> implements RoadTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RoadType> getAllRoadTypes() {
		Criteria criteria = createEntityCriteria();
		List<RoadType> roadTypes = (List<RoadType>) criteria.list();
		
		return roadTypes;
	}

}
