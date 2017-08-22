<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
package pe.openebusiness.ebank.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.FileType;

public interface MassiveChargeService {
	
	List<FileType> getAllFileTypes();
	
	CustomHttpResponse postFile(Integer type_id, MultipartFile file);

}
<<<<<<< HEAD
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
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
