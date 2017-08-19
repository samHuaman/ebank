<<<<<<< HEAD
package pe.openebusiness.ebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.FileType;
import pe.openebusiness.ebank.service.MassiveChargeService;

@RestController
@RequestMapping(value = "massive-charge")
public class MassiveChargeController {
	
	@Autowired
	MassiveChargeService chargeService;
	
	@ResponseBody
	@RequestMapping(value = "getAllFileTypes")
	private List<FileType> getAllFileTypes() {
		List<FileType> fileTypes = chargeService.getAllFileTypes();
		return fileTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "postFile", method = RequestMethod.POST)
	private CustomHttpResponse postFile(Integer type_id, @RequestParam("file") MultipartFile file) {
		CustomHttpResponse response = chargeService.postFile(type_id, file);
		return response;
	}

}
=======
package pe.openebusiness.ebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.openebusiness.ebank.bind.CustomHttpResponse;
import pe.openebusiness.ebank.model.FileType;
import pe.openebusiness.ebank.service.MassiveChargeService;

@RestController
@RequestMapping(value = "massive-charge")
public class MassiveChargeController {
	
	@Autowired
	MassiveChargeService chargeService;
	
	@ResponseBody
	@RequestMapping(value = "getAllFileTypes")
	private List<FileType> getAllFileTypes() {
		List<FileType> fileTypes = chargeService.getAllFileTypes();
		return fileTypes;
	}
	
	@ResponseBody
	@RequestMapping(value = "postFile", method = RequestMethod.POST)
	private CustomHttpResponse postFile(Integer type_id, @RequestParam("file") MultipartFile file) {
		CustomHttpResponse response = chargeService.postFile(type_id, file);
		return response;
	}

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
