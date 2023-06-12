package com.CampusMall.Service;

import com.CampusMall.Mapper.ProductTypeMapper;
import com.CampusMall.Pojo.ProductType;
import com.CampusMall.Pojo.ProductTypeExample;
import com.CampusMall.Service.ServiceImpl.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductType> GetProductType() {
        return productTypeMapper.selectByExample(null);
    }

    @Override
    public String insert(String TypeName) {
        int n = productTypeMapper.countByExample(null);
        n=n+1001;
        String TypeId = String.valueOf(n);
        ProductTypeExample example = new ProductTypeExample();
        example.createCriteria().andTypeNameEqualTo(TypeName);
        if(productTypeMapper.selectByExample(example).size()>=1){
            return "该商品类型已经存在";
        }
        ProductType productType= new ProductType();
        productType.setTypeId(TypeId);
        productType.setTypeName(TypeName);
        productTypeMapper.insertSelective(productType);
        return "添加成功";
    }

    @Override
    public int delete(String TypeId) {
        ProductTypeExample example = new ProductTypeExample();
        example.createCriteria().andTypeIdEqualTo(TypeId);
        return productTypeMapper.deleteByExample(example);
    }
}
