package pe.openebusiness.ebank.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.FileType;

public interface FileTypeDao {
	
	List<FileType> getAllFileTypes();
	
	CustomHttpResponse postFile(Integer type_id, @RequestParam("file") MultipartFile file);

}
