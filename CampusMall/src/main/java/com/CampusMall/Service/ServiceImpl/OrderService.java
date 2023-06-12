package com.CampusMall.Service.ServiceImpl;

import com.CampusMall.Pojo.Order;
import com.CampusMall.Pojo.Product;

import java.util.List;

public interface OrderService {
    public int CreateOrder(String UserId,String CartId);
    public List<Order> getOrderInfo(String UserId);
    public int DeleteOrder(String OrderId);
}
