package pe.openebusiness.ebank.dao;

import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.PaymentTemp;


public class PaymentTempDaoImpl extends AbstractDao<Integer, PaymentTemp> implements PaymentTempDao {

	@Override
	public CustomHttpResponse saveFromFile(MultipartFile file) {
		
		return null;
	}

}
