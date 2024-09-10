package com.it.rmu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.model.ResponseModel;
import com.it.rmu.service.GenExcelService;
import com.it.rmu.service.GenPdfService;
import com.it.rmu.service.ManageUserService;
import com.it.rmu.utils.Constants;

@RestController
@RequestMapping("/manage/user")
public class ManageUserController {
	

	
	@Autowired
	private ManageUserService manageUserService;
	
	@Autowired
	private GenPdfService genPdfService;
	
	@Autowired
	private GenExcelService genExcelService;
	
	@GetMapping("/getAllUser")
	public ResponseModel getAllUser() {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(manageUserService.getAllUser());
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@GetMapping("/download/pdf")
	public ResponseEntity<?> downloadPdf() throws IOException {

		File file = genPdfService.genPDF(manageUserService.getAllUser(), Constants.TYPE_CUSTOMER);
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=user-data.pdf");
	    
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(file.length())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}
	
	@GetMapping("/download/excel")
	public ResponseEntity<?> download() throws IOException {

		File file = genExcelService.genExcel(manageUserService.getAllUser(), Constants.TYPE_CUSTOMER);
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=user-data.xlsx");
	    
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(file.length())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}
}