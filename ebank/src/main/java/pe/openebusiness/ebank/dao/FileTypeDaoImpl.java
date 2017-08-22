package pe.openebusiness.ebank.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.FileType;

@Component
@Repository(value = "fileTypeDao")
public class FileTypeDaoImpl extends AbstractDao<Integer, FileType> implements FileTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<FileType> getAllFileTypes() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("description"));
		
		List<FileType> fileTypes = (List<FileType>) criteria.list();
		return fileTypes;
	}

	@Override
	public CustomHttpResponse postFile(Integer type_id, MultipartFile file) {
		CustomHttpResponse response = new CustomHttpResponse();
		
		InputStream iStream = null;
		OutputStream oStream = null;
		
		String fileName = file.getOriginalFilename();
		String fileFolder = "E:/practice/input/";
		
		File newFile = new File(fileFolder + fileName);
		
		try {
			iStream = file.getInputStream();
			
			newFile.createNewFile();
			
			oStream = new FileOutputStream(newFile, false);
			
			int read = 0;
			byte[] bs = new byte[1024];
			
			while ((read = iStream.read(bs)) != -1) {
				oStream.write(bs, 0, read);
			}
			
			response.setStatusCode(200);
			response.setMessage(newFile.getAbsolutePath());
		} 
		catch (IOException ex) {
			ex.printStackTrace();
			
			response.setStatusCode(500);
			response.setMessage(ex.getMessage());
			response.setStackTrace(ex.getStackTrace());
		}
		
		return response;
	}

}