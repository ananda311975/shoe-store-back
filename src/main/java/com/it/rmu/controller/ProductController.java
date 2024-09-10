package com.it.rmu.controller;

import java.io.IOException;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.it.rmu.model.ProductRequestModel;
import com.it.rmu.model.ResponseModel;
import com.it.rmu.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getById")
	public ResponseModel getById(@RequestParam(name = "productId") Integer productId) {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(productService.getById(productId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	


	
	
	
	@GetMapping("/getProductTypeAll")
	public ResponseModel getProductTypeAll() {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(productService.getProductTypeAll());
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@GetMapping("/getProductImgByProductId")
	public ResponseModel getProductImgByProductId(@RequestParam(name = "productId") Integer productId) {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(productService.getProductImgByProductId(productId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@GetMapping("/getAll")
	public ResponseModel getAll() {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(productService.getAll());
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@PostMapping("/save")
	public ResponseModel save(@RequestBody ProductRequestModel productRequest) {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(productService.save(productRequest));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@PutMapping("/update/{productId}")
	public ResponseModel update(@RequestBody ProductRequestModel productRequest, @PathVariable Integer productId) {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(productService.update(productRequest, productId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete")
	public ResponseModel delete(@RequestParam(name = "productId") Integer productId) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			response.setData(productService.delete(productId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
//	@GetMapping("/getImage")
//	public ResponseEntity<byte[]> getImage(@RequestParam(name = "fileName") String fileName) throws IOException {
//
//		return ResponseEntity.ok(productService.getImage(fileName));
//	}
//	
	@GetMapping("/getImageByte")
	public ResponseEntity<byte[]> getImageByte(@RequestParam(name = "fileName") String fileName) throws IOException, DataFormatException {

		return ResponseEntity.ok(productService.getImageByte(fileName));
	}
	
	@PostMapping(value =("/saveImage/{productId}") , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseModel saveImage(@RequestParam("file") MultipartFile file, @PathVariable Integer productId) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			response.setData(productService.saveImage(file, productId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
	@DeleteMapping(value =("/deleteImgByFileName"))
	public ResponseModel deleteImgByFileName(@RequestParam(name = "fileName") String fileName) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			productService.deleteImgByFileName(fileName);
			response.setData("SUCCESS");
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
}

