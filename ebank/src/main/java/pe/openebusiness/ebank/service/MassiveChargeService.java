<<<<<<< HEAD
package pe.openebusiness.ebank.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.FileType;

public interface MassiveChargeService {
	
	List<FileType> getAllFileTypes();
	
	CustomHttpResponse postFile(Integer type_id, MultipartFile file);

}
=======
package pe.openebusiness.ebank.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.FileType;

public interface MassiveChargeService {
	
	List<FileType> getAllFileTypes();
	
	CustomHttpResponse postFile(Integer type_id, MultipartFile file);

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
