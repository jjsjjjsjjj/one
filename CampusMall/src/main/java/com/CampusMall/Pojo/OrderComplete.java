package com.CampusMall.Pojo;

import java.util.Date;

public class OrderComplete {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.to_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private Long toId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.order_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.user_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.order_price
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private Long orderPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.order_user
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private String orderUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.order_phone
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private Long orderPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.order_address
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private String orderAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.order_create
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private Date orderCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.p_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private String pId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.p_count
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private Long pCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.p_name
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private String pName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_complete.p_price
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    private Long pPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.to_id
     *
     * @return the value of t_order_complete.to_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public Long getToId() {
        return toId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.to_id
     *
     * @param toId the value for t_order_complete.to_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setToId(Long toId) {
        this.toId = toId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.order_id
     *
     * @return the value of t_order_complete.order_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.order_id
     *
     * @param orderId the value for t_order_complete.order_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.user_id
     *
     * @return the value of t_order_complete.user_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.user_id
     *
     * @param userId the value for t_order_complete.user_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.order_price
     *
     * @return the value of t_order_complete.order_price
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public Long getOrderPrice() {
        return orderPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.order_price
     *
     * @param orderPrice the value for t_order_complete.order_price
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.order_user
     *
     * @return the value of t_order_complete.order_user
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public String getOrderUser() {
        return orderUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.order_user
     *
     * @param orderUser the value for t_order_complete.order_user
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser == null ? null : orderUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.order_phone
     *
     * @return the value of t_order_complete.order_phone
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public Long getOrderPhone() {
        return orderPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.order_phone
     *
     * @param orderPhone the value for t_order_complete.order_phone
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setOrderPhone(Long orderPhone) {
        this.orderPhone = orderPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.order_address
     *
     * @return the value of t_order_complete.order_address
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public String getOrderAddress() {
        return orderAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.order_address
     *
     * @param orderAddress the value for t_order_complete.order_address
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress == null ? null : orderAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.order_create
     *
     * @return the value of t_order_complete.order_create
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public Date getOrderCreate() {
        return orderCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.order_create
     *
     * @param orderCreate the value for t_order_complete.order_create
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setOrderCreate(Date orderCreate) {
        this.orderCreate = orderCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.p_id
     *
     * @return the value of t_order_complete.p_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public String getpId() {
        return pId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.p_id
     *
     * @param pId the value for t_order_complete.p_id
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.p_count
     *
     * @return the value of t_order_complete.p_count
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public Long getpCount() {
        return pCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.p_count
     *
     * @param pCount the value for t_order_complete.p_count
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setpCount(Long pCount) {
        this.pCount = pCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.p_name
     *
     * @return the value of t_order_complete.p_name
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public String getpName() {
        return pName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.p_name
     *
     * @param pName the value for t_order_complete.p_name
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_complete.p_price
     *
     * @return the value of t_order_complete.p_price
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public Long getpPrice() {
        return pPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_complete.p_price
     *
     * @param pPrice the value for t_order_complete.p_price
     *
     * @mbggenerated Tue May 30 21:05:08 CST 2023
     */
    public void setpPrice(Long pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "OrderComplete{" +
                "toId=" + toId +
                ", orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderUser='" + orderUser + '\'' +
                ", orderPhone=" + orderPhone +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderCreate=" + orderCreate +
                ", pId='" + pId + '\'' +
                ", pCount=" + pCount +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                '}';
    }
}