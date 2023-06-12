package com.CampusMall.Control;

import com.CampusMall.Pojo.*;
import com.CampusMall.Service.ServiceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/Order")
@CrossOrigin
public class OrderControl {
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderCompleteService orderCompleteService;
    @RequestMapping(value = "/CreateOrder",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public String CreateOrder(@RequestParam(value = "cartId[]",required=false) List<String> cartId,@RequestParam("userId") String userId ){
        //String  CartId=(String)Req.getParameter("CartId");
        System.out.println(cartId.toString());
        //String  UserId=(String)Req.getParameter("UserId");
        System.out.println(userId);
        for(int i=0;i<cartId.size();i++){
            int tag=orderService.CreateOrder(userId,cartId.get(i));
            if(tag==-1){
                return "请添加电话号码";
            }else if(tag==-2){
                return  "请完善地址";
            }
        }
        cartService.DeleteCartProductById(cartId);
        return "生成订单成功";
    }
    @RequestMapping(value = "/getOrderInfo",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<Order1> getOrderInfo(HttpServletRequest Req) {
        String UserId = Req.getParameter("userId");
        List<Order1> order1s= new LinkedList<>();
        List<Order> orders =orderService.getOrderInfo(UserId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(int i=0;i<orders.size();i++){
            Order order = orders.get(i);
            Order1 order1 = new Order1();
            order1.setOrderAddress(order.getOrderAddress());
            order1.setOrderCreate(simpleDateFormat.format(order.getOrderCreate()));
            order1.setOrderId(order.getOrderId());
            order1.setOrderPhone(order.getOrderPhone());
            order1.setOrderPrice(order.getpPrice());
            order1.setOrderUser(order.getOrderUser());
            order1.setpCount(order.getpCount());
            order1.setpId(order.getpId());
            order1.setpName(order.getpName());
            order1.setpPrice(order.getpPrice());
            order1.setToId(order.getToId());
            order1.setUserId(order.getUserId());
            order1s.add(order1);
        }
        return order1s;
    }
    @RequestMapping(value = "/deleteOrder",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int deleteOrder(HttpServletRequest Req){
        String orderId = Req.getParameter("orderId");
        return orderService.DeleteOrder(orderId);
    }

    @RequestMapping(value = "/payOrder",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public int  payOrder(@RequestBody Order1 order1){
        String OrderId = order1.getOrderId();
        System.out.println(order1);
        orderService.DeleteOrder(OrderId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        OrderComplete orderComplete = new OrderComplete();
        orderComplete.setOrderAddress(order1.getOrderAddress());
        try {
            orderComplete.setOrderCreate(simpleDateFormat.parse(order1.getOrderCreate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andPIdEqualTo(order1.getpId());
        Product product = productService.SelectProduct(productExample).get(0);
        product.setpNum(product.getpNum()-order1.getpCount());
        productService.update(order1.getpId(),product);
        orderComplete.setOrderId(order1.getOrderId());
        orderComplete.setOrderPhone(order1.getOrderPhone());
        orderComplete.setOrderPrice(order1.getpPrice());
        orderComplete.setOrderUser(order1.getOrderUser());
        orderComplete.setpCount(order1.getpCount());
        orderComplete.setpId(order1.getpId());
        orderComplete.setpName(order1.getpName());
        orderComplete.setpPrice(order1.getpPrice());
        orderComplete.setToId(null);
        orderComplete.setUserId(order1.getUserId());
        System.out.println(orderComplete.toString());
        return orderCompleteService.insert(orderComplete);
    }
}
