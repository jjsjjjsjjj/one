package com.CampusMall.Service;

import com.CampusMall.Mapper.CartMapper;
import com.CampusMall.Mapper.ProductMapper;
import com.CampusMall.Pojo.Cart;
import com.CampusMall.Pojo.CartExample;
import com.CampusMall.Pojo.Product;
import com.CampusMall.Pojo.ProductExample;
import com.CampusMall.Service.ServiceImpl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("CartService")
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    ProductMapper productMapper;
    @Override
    public Long  addProductToCart(String PId, String UserId,Long PCount) {
        Long timeNew = System.currentTimeMillis()/1000;
        timeNew=timeNew+(int)((Math.random()*9+1)*1000);
        LocalDate date = LocalDate.now();
        String n="tc"+date.toString().split("-")[0]+date.toString().split("-")[1]+date.toString().split("-")[2]+String.valueOf(timeNew);
        Cart cart=new Cart();
        cart.setpId(PId);
        cart.setUserId(UserId);
        cart.setCartId(n);
        cart.setpCount(PCount);
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andPIdEqualTo(PId);
        Product product= productMapper.selectByExample(productExample).get(0);
        cart.setpPrice(product.getpPrice());
        product.setpNum(product.getpNum()-PCount);
        cart.setpName(product.getpName());
        //productMapper.updateByExampleSelective(product,productExample);
        cartMapper.insertSelective(cart);
        return product.getpNum();
    }

    @Override
    public int DeleteCartProduct(List<Cart> Carts) {
       CartExample example= new CartExample();
      // CartExample.Criteria criteria= example.createCriteria();
       for(int i=0;i<Carts.size();i++){
            Cart cart = Carts.get(i);
            String CartId = cart.getCartId();
            example.or().andCartIdEqualTo(CartId);
       }
       return cartMapper.deleteByExample(example);
    }

    @Override
    public int DeleteCartProductById(List<String> CartIds) {
        CartExample example= new CartExample();
        for(int i=0;i<CartIds.size();i++){
            String  cartId = CartIds.get(i);
            example.or().andCartIdEqualTo(cartId);
        }
        return cartMapper.deleteByExample(example);
    }

    @Override
    public List<Cart> GetCartInfo(String UserId) {
        CartExample example= new CartExample();
        example.createCriteria().andUserIdEqualTo(UserId);
        return cartMapper.selectByExample(example);
    }


}
