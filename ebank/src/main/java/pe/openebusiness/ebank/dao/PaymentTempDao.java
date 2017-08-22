package pe.openebusiness.ebank.dao;

import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;

public interface PaymentTempDao {
	
	CustomHttpResponse saveFromFile(MultipartFile file);

}
