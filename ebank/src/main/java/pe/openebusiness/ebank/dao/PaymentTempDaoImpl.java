<<<<<<< HEAD
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
=======
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
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
