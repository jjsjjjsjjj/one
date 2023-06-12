package com.CampusMall.Service.ServiceImpl;

import com.CampusMall.Pojo.Product;
import com.CampusMall.Pojo.ProductExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    public PageInfo<Product> getProductPage(Integer PageNum,Integer PageSize);
    public List<Product> SelectProduct(ProductExample example);
    public Product getProductInfo(String PId);
    public int update(String PId,Product product);
    public int insert(Product product);
    public int delete(String PId);
}
