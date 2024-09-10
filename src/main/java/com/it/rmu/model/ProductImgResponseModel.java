package com.it.rmu.model;

public class ProductImgResponseModel {
	
	private Integer productImgId;
	private Integer productId;
	private String productImgPath;
	private String productImgName;
	private byte[] productImgData;
	private String status;

	public Integer getProductImgId() {
	return productImgId;
	}
	public void setProductImgId(Integer productImgId) {
	this.productImgId = productImgId;
	}
	public Integer getProductId() {
	return productId;
	}
	public void setProductId(Integer productId) {
	this.productId = productId;
	}
	public String getProductImgPath() {
	return productImgPath;
	}
	public void setProductImgPath(String productImgPath) {
	this.productImgPath = productImgPath;
	}
	public String getProductImgName() {
	return productImgName;
	}
	public void setProductImgName(String productImgName) {
	this.productImgName = productImgName;
	}
	
	public byte[] getProductImgData() {
		return productImgData;
	}
	public void setProductImgData(byte[] productImgData) {
		this.productImgData = productImgData;
	}
	public String getStatus() {
	return status;
	}
	public void setStatus(String status) {
	this.status = status;
	}

}
