package com.it.rmu.model;

import java.math.BigDecimal;

public class ProductResponseModel {
	
	private Integer productId;
	private Integer productTypeId;
	private String productName;
	private String productDesc;
	private BigDecimal price;
	private Integer quantity;
	private String status;

	public Integer getProductId() {
	return productId;
	}
	public void setProductId(Integer productId) {
	this.productId = productId;
	}
	public Integer getProductTypeId() {
	return productTypeId;
	}
	public void setProductTypeId(Integer productTypeId) {
	this.productTypeId = productTypeId;
	}
	public String getProductName() {
	return productName;
	}
	public void setProductName(String productName) {
	this.productName = productName;
	}
	public String getProductDesc() {
	return productDesc;
	}
	public void setProductDesc(String productDesc) {
	this.productDesc = productDesc;
	}
	public BigDecimal getPrice() {
	return price;
	}
	public void setPrice(BigDecimal price) {
	this.price = price;
	}
	public Integer getQuantity() {
	return quantity;
	}
	public void setQuantity(Integer quantity) {
	this.quantity = quantity;
	}

	public String getStatus() {
	return status;
	}
	public void setStatus(String status) {
	this.status = status;
	}
}
