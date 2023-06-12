package com.CampusMall.Control;


import com.CampusMall.Pojo.Cart;
import com.CampusMall.Pojo.Product;
import com.CampusMall.Service.ServiceImpl.CartService;
import com.CampusMall.Service.ServiceImpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Cart")
@CrossOrigin
public class CartControl {
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/addProductToCart",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public Long  addProductToCart(HttpServletRequest Req){
        String  PId=Req.getParameter("PId");
        String  UserId=Req.getParameter("UserId");
        Long PCount =Long.valueOf((String) Req.getParameter("PCount"));
        return cartService.addProductToCart(PId,UserId,PCount);
    }
    @RequestMapping(value = "/DeleteCartProduct",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public int DeleteCartProduct(@RequestBody List<Cart> Carts){
        return cartService.DeleteCartProduct(Carts);
    }
    @RequestMapping(value = "/GetCartInfo",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<Cart> GetCartInfo(HttpServletRequest Req){
        String userId = (String)Req.getParameter("userId");
        return cartService.GetCartInfo(userId);
    }
}
