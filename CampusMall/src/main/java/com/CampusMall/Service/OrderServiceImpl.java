package com.CampusMall.Service;

import com.CampusMall.Mapper.CartMapper;
import com.CampusMall.Mapper.OrderMapper;
import com.CampusMall.Mapper.ProductMapper;
import com.CampusMall.Mapper.UserMapper;
import com.CampusMall.Pojo.*;
import com.CampusMall.Service.ServiceImpl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CartMapper cartMapper;
    @Override
    public int CreateOrder(String UserId, String CartId) {
        Long timeNew = System.currentTimeMillis()/1000;
        timeNew=timeNew+(int)((Math.random()*9+1)*1000);
        LocalDate date = LocalDate.now();
        String n="to"+date.toString().split("-")[0]+date.toString().split("-")[1]+date.toString().split("-")[2]+String.valueOf(timeNew);
        Order order = new Order();
        order.setOrderId(n);
        order.setOrderCreate(new Date());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(UserId);
        User user = userMapper.selectByExample(userExample).get(0);
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCartIdEqualTo(CartId);
        Cart cart = cartMapper.selectByExample(cartExample).get(0);
        if(user.getUserAddress()==null){return -2;}
        order.setOrderAddress(user.getUserAddress());
        if(user.getUserPhone()==null){return -1;}
        order.setOrderPhone(user.getUserPhone());
        order.setUserId(UserId);
        order.setOrderUser(user.getUserName());
        order.setpId(cart.getpId());

//        ProductExample pexample = new ProductExample();
//        pexample.createCriteria().andPIdEqualTo(PId);
//        Product product = productMapper.selectByExample(pexample).get(0);
        order.setpPrice(cart.getpPrice());
        order.setpCount(cart.getpCount());
        order.setpName(cart.getpName());
        order.setOrderPrice(order.getpPrice()*order.getpCount());
        return orderMapper.insert(order);
    }

    @Override
    public List<Order> getOrderInfo(String UserId) {
        OrderExample orderExample= new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(UserId);
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public int DeleteOrder(String OrderId) {
        OrderExample example = new OrderExample();
        example.createCriteria().andOrderIdEqualTo(OrderId);
        return orderMapper.deleteByExample(example);
    }
}
