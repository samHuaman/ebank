package pe.openebusiness.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.openebusiness.ebank.model.DocumentType;

@Component
@Repository(value = "documentTypeDao")
public class DocumentTypeDaoImpl extends AbstractDao<Integer, DocumentType> implements DocumentTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentType> getAllDocumentTypes() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<DocumentType> documentTypes = (List<DocumentType>) criteria.list();
		return documentTypes;
	}

}
