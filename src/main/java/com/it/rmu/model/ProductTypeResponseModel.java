package com.it.rmu.model;

public class ProductTypeResponseModel {
	
	private Integer productTypeId;
	private String productTypeName;
	private String productTypeDesc;
	private String status;

	public Integer getProductTypeId() {
	return productTypeId;
	}
	public void setProductTypeId(Integer productTypeId) {
	this.productTypeId = productTypeId;
	}
	public String getProductTypeName() {
	return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
	this.productTypeName = productTypeName;
	}
	public String getProductTypeDesc() {
	return productTypeDesc;
	}
	public void setProductTypeDesc(String productTypeDesc) {
	this.productTypeDesc = productTypeDesc;
	}
	public String getStatus() {
	return status;
	}
	public void setStatus(String status) {
	this.status = status;
	}

}
