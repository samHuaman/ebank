package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.HousingType;

@Component
@Repository(value = "housingTypeDao")
public class HousingTypeDaoImpl extends AbstractDao<Integer, HousingType> implements HousingTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<HousingType> getAllHousingTypes() {
		Criteria criteria = createEntityCriteria();
		List<HousingType> housingTypes = (List<HousingType>) criteria.list();
		
		return housingTypes;
	}

}
