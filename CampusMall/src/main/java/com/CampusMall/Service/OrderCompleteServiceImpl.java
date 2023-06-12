package com.CampusMall.Service;

import com.CampusMall.Mapper.OrderCompleteMapper;
import com.CampusMall.Pojo.OrderComplete;
import com.CampusMall.Service.ServiceImpl.OrderCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderCompleteService")
public class OrderCompleteServiceImpl implements OrderCompleteService {
    @Autowired
    OrderCompleteMapper orderCompleteMapper;
    @Override
    public int insert(OrderComplete orderComplete) {
        return orderCompleteMapper.insertSelective(orderComplete);
    }
}
