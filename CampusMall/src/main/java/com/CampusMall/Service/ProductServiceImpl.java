package com.CampusMall.Service;

import com.CampusMall.Mapper.ProductMapper;
import com.CampusMall.Pojo.Product;
import com.CampusMall.Pojo.ProductExample;
import com.CampusMall.Service.ServiceImpl.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public PageInfo<Product> getProductPage(Integer PageNum,Integer PageSize) {
        PageHelper.startPage(PageNum,PageSize);
        List<Product> List=productMapper.selectByExample(null);
        PageInfo<Product> page=new PageInfo<Product>(List,5);
        return page;
    }

    @Override
    public List<Product> SelectProduct(ProductExample example) {
        return productMapper.selectByExample(example);
    }

    @Override
    public Product getProductInfo(String PId) {
        ProductExample example=new ProductExample();
        example.createCriteria().andPIdEqualTo(PId);
        return productMapper.selectByExample(example).get(0);
    }

    @Override
    public int update(String PId, Product product) {
        ProductExample example= new ProductExample();
        example.createCriteria().andPIdEqualTo(PId);
        return productMapper.updateByExampleSelective(product,example);
    }

    @Override
    public int insert(Product product) {
        Long timeNew = System.currentTimeMillis()/1000;
        timeNew=timeNew+(int)((Math.random()*9+1)*1000);
        LocalDate date = LocalDate.now();
        String n="tp"+date.toString().split("-")[0]+date.toString().split("-")[1]+date.toString().split("-")[2]+String.valueOf(timeNew);
        product.setpId(n);
        return productMapper.insertSelective(product);
    }

    @Override
    public int delete(String PId) {
        ProductExample example = new ProductExample();
        example.createCriteria().andPIdEqualTo(PId);
        return productMapper.deleteByExample(example);
    }

}
