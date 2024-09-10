package com.it.rmu.model;



public class OrderRequestModel {

    private Integer ordersId;
    private Integer productId[];
    private Integer userId;
    private String address;
    private Integer quantity[];
    private String status;
    private String phone;



    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getOrdersId() {
        return ordersId;
    }
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }
    public Integer[] getProductId() {
        return productId;
    }
    public void setProductId(Integer[] productId) {
        this.productId = productId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer[] getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer[] quantity) {
        this.quantity = quantity;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }





}
