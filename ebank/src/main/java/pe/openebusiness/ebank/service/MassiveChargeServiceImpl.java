<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
package pe.openebusiness.ebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.dao.FileTypeDao;
import pe.openebusiness.ebank.model.FileType;

@Component
@Service(value = "massiveChargeService")
@Transactional
public class MassiveChargeServiceImpl implements MassiveChargeService {
	
	@Autowired
	FileTypeDao fileTypeDao;

	@Override
	public List<FileType> getAllFileTypes() {
		return fileTypeDao.getAllFileTypes();
	}

	@Override
	public CustomHttpResponse postFile(Integer type_id, MultipartFile file) {
		return fileTypeDao.postFile(type_id, file);
	}

<<<<<<< HEAD
=======
package pe.openebusiness.ebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.dao.FileTypeDao;
import pe.openebusiness.ebank.model.FileType;

@Component
@Service(value = "massiveChargeService")
@Transactional
public class MassiveChargeServiceImpl implements MassiveChargeService {
	
	@Autowired
	FileTypeDao fileTypeDao;

	@Override
	public List<FileType> getAllFileTypes() {
		return fileTypeDao.getAllFileTypes();
	}

	@Override
	public CustomHttpResponse postFile(Integer type_id, MultipartFile file) {
		return fileTypeDao.postFile(type_id, file);
	}

>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
}