package com.CampusMall.Control;


import com.CampusMall.Pojo.Product;
import com.CampusMall.Pojo.ProductType;
import com.CampusMall.Service.ServiceImpl.ProductTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ProductType")
@CrossOrigin
public class ProductTypeControl {
    @Autowired
    ProductTypeService productTypeService;
    @RequestMapping(value = "/GetProductType",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<ProductType> GetProductType(){
        return productTypeService.GetProductType();
    }
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public String insert(@RequestParam("productTypeName") String productTypeName){
        return productTypeService.insert(productTypeName);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int delete(@RequestParam("typeId") String TypeId){
        return productTypeService.delete(TypeId);
    }

}

