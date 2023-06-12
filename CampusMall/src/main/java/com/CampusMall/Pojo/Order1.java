package com.CampusMall.Pojo;

import java.util.Date;

public class Order1 {
    private Long toId;
    private String orderId;
    private String userId;
    private Long orderPrice;
    private String orderUser;
    private Long orderPhone;
    private String orderAddress;
    private String orderCreate;
    private String pId;
    private Long pCount;
    private String pName;
    private Long pPrice;

    public Order1() {
    }

    public Order1(Long toId, String orderId, String userId, Long orderPrice, String orderUser, Long orderPhone, String orderAddress, String orderCreate, String pId, Long pCount, String pName, Long pPrice) {
        this.toId = toId;
        this.orderId = orderId;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.orderUser = orderUser;
        this.orderPhone = orderPhone;
        this.orderAddress = orderAddress;
        this.orderCreate = orderCreate;
        this.pId = pId;
        this.pCount = pCount;
        this.pName = pName;
        this.pPrice = pPrice;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public Long getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(Long orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderCreate() {
        return orderCreate;
    }

    public void setOrderCreate(String orderCreate) {
        this.orderCreate = orderCreate;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Long getpCount() {
        return pCount;
    }

    public void setpCount(Long pCount) {
        this.pCount = pCount;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Long getpPrice() {
        return pPrice;
    }

    public void setpPrice(Long pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "Order1{" +
                "toId=" + toId +
                ", orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderUser='" + orderUser + '\'' +
                ", orderPhone=" + orderPhone +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderCreate='" + orderCreate + '\'' +
                ", pId='" + pId + '\'' +
                ", pCount=" + pCount +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                '}';
    }
}
