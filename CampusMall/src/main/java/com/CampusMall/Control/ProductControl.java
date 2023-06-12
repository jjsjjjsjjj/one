package com.CampusMall.Control;



import com.CampusMall.Pojo.Product;
import com.CampusMall.Pojo.ProductExample;
import com.CampusMall.Service.ServiceImpl.ProductService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Product")
@CrossOrigin
public class ProductControl {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/GetPage/{PageNum}",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public PageInfo<Product> GetProductPage(@PathVariable("PageNum") Integer Num){
        PageInfo<Product> page=productService.getProductPage(Num,4);
        return page;
    }

    @RequestMapping(value = "/SelectProduct",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<Product> SelectProduct(HttpServletRequest Req){
        ProductExample example=new ProductExample();
        example.createCriteria().andPIdEqualTo((String) Req.getParameter("PId"));
        example.createCriteria().andPNameEqualTo(Req.getParameter("PName"));
        example.createCriteria().andPPriceEqualTo(Long.valueOf((String) Req.getParameter("PPrice")));
        example.createCriteria().andPTypeEqualTo((String) Req.getParameter("PType"));
        return productService.SelectProduct(example);
    }


    @RequestMapping(value = "/GetProductInfo",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public Product GetProductInfo(HttpServletRequest Req){
        String PId=Req.getParameter("pId");
        return productService.getProductInfo(PId);
    }


    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public int insert(@RequestBody Product product){
        return productService.insert(product);
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public int update(@RequestBody Product product){
        String PId=product.getpId();
        return productService.update(PId,product);
    }

    @RequestMapping(value = "/GetAllProduct",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<Product> getAllProduct(){
        return productService.SelectProduct(null);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int delete(@RequestParam("pId") String pId){
        return productService.delete(pId);
    }
}
