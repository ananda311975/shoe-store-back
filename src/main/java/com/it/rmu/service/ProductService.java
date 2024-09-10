package com.it.rmu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.rmu.entity.ProductEntity;
import com.it.rmu.entity.ProductImgEntity;
import com.it.rmu.entity.ProductTypeEntity;
import com.it.rmu.model.ProductImgResponseModel;
import com.it.rmu.model.ProductRequestModel;
import com.it.rmu.model.ProductResponseModel;
import com.it.rmu.model.ProductTypeResponseModel;
import com.it.rmu.repository.ProductImgRepository;
import com.it.rmu.repository.ProductRepository;
import com.it.rmu.repository.ProductTypeRepository;
import com.it.rmu.utils.Constants;
import com.it.rmu.utils.ImgUtils;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductImgRepository productImgRepository;
	
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	public ProductResponseModel getById(Integer productId) {
		
		ProductResponseModel response = null;
		
		Optional<ProductEntity> entity = productRepository.findById(productId);
		
		if(entity.isPresent()) {
			ProductEntity product = entity.get();
			response = new ProductResponseModel();
			
			response.setProductId(product.getId());
			response.setProductName(product.getProductName());
			response.setProductDesc(product.getProductDesc());
			response.setProductTypeId(product.getProductTypeId());
			response.setPrice(product.getPrice());
			response.setQuantity(product.getQuantity());
			response.setStatus(product.getStatus());
			
		}

		return response;
		
	}
	

	
	
	public List<ProductResponseModel> getAll() {
		
		List<ProductResponseModel> response = null;
		
		List<ProductEntity> entitys = productRepository.findAll();
		
		if(null != entitys) {
			response = new ArrayList<>();
			for(ProductEntity product : entitys) {
				
				ProductResponseModel object = new ProductResponseModel();
				
				object.setProductId(product.getId());
				object.setProductName(product.getProductName());
				object.setProductDesc(product.getProductDesc());
				object.setProductTypeId(product.getProductTypeId());
				object.setPrice(product.getPrice());
				object.setQuantity(product.getQuantity());
				object.setStatus(product.getStatus());
				
				response.add(object);
			}

		}

		return response;
		
	}
	
	@Transactional
	public Integer save(ProductRequestModel productRequest) throws IOException {
		
		Integer response = null;
		
		if(null != productRequest) {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductName(productRequest.getProductName());
			productEntity.setProductDesc(productRequest.getProductDesc());
			productEntity.setProductTypeId(productRequest.getProductTypeId());
			productEntity.setPrice(productRequest.getPrice());
			productEntity.setQuantity(productRequest.getQuantity());
			productEntity.setStatus("1");
			productEntity.setCreateBy("Joey");
			productEntity.setCreateDate(new Date());
			productEntity.setUpdateBy("Joey Update");
			productEntity.setUpdateDate(new Date());
			
			productEntity = productRepository.save(productEntity);
			response = productEntity.getId();
			
		}
		
		
		return response;
		
	}
	
	@Transactional
	public Integer update(ProductRequestModel productRequest, Integer productId) throws IOException {
		Integer response = null;
		
		Optional<ProductEntity> productEntity = productRepository.findById(productId);
		if(productEntity.isPresent()) {
			ProductEntity product = productEntity.get();
			product.setProductName(null != productRequest.getProductName() ? productRequest.getProductName() : product.getProductName());
			product.setProductDesc(null != productRequest.getProductDesc() ? productRequest.getProductDesc() : product.getProductDesc());
			product.setProductTypeId(null != productRequest.getProductTypeId() ? productRequest.getProductTypeId() : product.getProductTypeId());
			product.setPrice(null != productRequest.getPrice() ? productRequest.getPrice() : product.getPrice());
			product.setQuantity(null != productRequest.getQuantity() ? productRequest.getQuantity() : product.getQuantity());
			product.setUpdateBy("Joey Update New");
			product.setUpdateDate(new Date());
			
			product = productRepository.save(product);
			
			response = product.getId();
			
		}
		
		return response;
	}
	
	@Transactional
	public Integer delete(Integer productId) throws IOException {
		Integer response = null;
		if(null != productId) {
			productRepository.deleteByProductId(productId);
			this.removeImgAndDeleteFileImgByProductId(productId);
			response = productId;
		}
		return response;
	}
	
	public List<ProductTypeResponseModel> getProductTypeAll(){
		List<ProductTypeResponseModel> response = null;
		
		List<ProductTypeEntity> productEntitys = productTypeRepository.findAll();
		if(null != productEntitys) {
			response = new ArrayList<>();
			for(ProductTypeEntity product : productEntitys) {
				ProductTypeResponseModel objectResponse = new ProductTypeResponseModel();
				objectResponse.setProductTypeId(product.getId());
				objectResponse.setProductTypeName(product.getProductTypeName());
				objectResponse.setProductTypeDesc(product.getProductTypeDesc());
				objectResponse.setStatus(product.getStatus());
				response.add(objectResponse);
			}
		}
		
		return response;
	}
	
	public List<ProductImgResponseModel> getProductImgByProductId(Integer productId){
		List<ProductImgResponseModel> response = null;
		
		List<ProductImgEntity> productImgList = productImgRepository.findByProductId(productId);
		
		if(null != productImgList) {
			response = new ArrayList<>();
			for(ProductImgEntity productImg : productImgList) {
				ProductImgResponseModel objectResponse = new ProductImgResponseModel();
				objectResponse.setProductImgId(productImg.getId());
				objectResponse.setProductId(productImg.getProductId());
				objectResponse.setProductImgName(productImg.getProductImgName());
				objectResponse.setProductImgPath(productImg.getProductImgPath());
				objectResponse.setProductImgData(productImg.getProductImgData());
				objectResponse.setStatus(productImg.getStatus());
				response.add(objectResponse);
			}
		}
		
		return response;
	}
	
	
	@Transactional
	public void removeImgAndDeleteFileImgByProductId(Integer productId) throws IOException {
		List<ProductImgEntity> productImgList = productImgRepository.findByProductId(productId);
		productImgRepository.deleteAll(productImgList);
	}
	
	@Transactional
	public void deleteImgByFileName(String fileName) throws IOException {
		ProductImgEntity productImgList = productImgRepository.findByProductName(fileName);
		productImgRepository.delete(productImgList);
	}
	
//	public byte[] getImage(String fileName) throws IOException {
//		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();	
//		String filePath = path + File.separator + Constants.PATH_FOLDER_UPLOAD + File.separator + Constants.PATH_TYPE_INPUT + File.separator + fileName;
//		File file = new File(filePath);
//		FileInputStream fl = new FileInputStream(file);
//        return StreamUtils.copyToByteArray(fl);
//	}
	
	public byte[] getImageByte(String fileName) throws IOException, DataFormatException {
		ProductImgEntity productImg = productImgRepository.findByProductName(fileName);
		
		if(null != productImg) {
			return ImgUtils.decompressImage(productImg.getProductImgData());
		}

        return null;
	}
	
	@Transactional
	public Integer saveImage(MultipartFile file, Integer productId) throws IOException {
		Integer response = null;
		if(null != file && null != productId) {
			ProductImgEntity productImg = new ProductImgEntity();
			String preFixNameFile = ImgUtils.genaratePrefixFile();
			String genarateFileName = ImgUtils.genarateFileName() +ImgUtils.subStrFileName(file.getOriginalFilename());
			String fileName = ImgUtils.concatStr(preFixNameFile, genarateFileName);
			productImg.setProductImgName(fileName);
			productImg.setProductImgPath(ImgUtils.getPathInput());
			productImg.setProductId(productId);
			productImg.setProductImgData(ImgUtils.compressImage(file.getBytes()));
			productImg.setStatus("1");
			productImg.setCreateBy("Joey");
			productImg.setCreateDate(new Date());
			productImg.setUpdateBy("Joey Update");
			productImg.setUpdateDate(new Date());
			productImg = productImgRepository.save(productImg);
			response = productImg.getId();
			
//			ImgUtils.saveFile(file, fileName, Constants.PATH_TYPE_INPUT);
		}
		return response;
	}
	
	@Transactional
	public void deleteImgSever(String fileName) throws IOException {
		if(null != fileName) {
			ImgUtils.deleteFile(fileName, Constants.PATH_TYPE_INPUT);
		}
		
	}
	
}

