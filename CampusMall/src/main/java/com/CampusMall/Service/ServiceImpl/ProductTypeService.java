package com.CampusMall.Service.ServiceImpl;

import com.CampusMall.Pojo.ProductType;

import java.util.List;

public interface ProductTypeService {
    public List<ProductType> GetProductType();
    public String insert(String TypeName);
    public int delete(String TypeId);
}
