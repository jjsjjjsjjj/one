package com.CampusMall.Service.ServiceImpl;

import com.CampusMall.Pojo.Cart;

import java.util.List;

public interface CartService {
    public Long  addProductToCart(String PId,String UserId,Long PCount);
    public int  DeleteCartProduct(List<Cart> Carts);
    public int  DeleteCartProductById(List<String> CartIds);
    public List<Cart> GetCartInfo(String UserId);
}
