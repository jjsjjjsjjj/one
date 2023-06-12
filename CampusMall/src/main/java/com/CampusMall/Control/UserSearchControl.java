package com.CampusMall.Control;

import com.CampusMall.Pojo.Product;
import com.CampusMall.Pojo.ProductExample;
import com.CampusMall.Pojo.SearchInfo;
import com.CampusMall.Pojo.UserSearch;
import com.CampusMall.Service.ServiceImpl.UserSearchService;
import com.CampusMall.Service.ServiceImpl.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/UserSearch")
@CrossOrigin
public class UserSearchControl {
    @Autowired
    UserSearchService userSearchService;
    @RequestMapping(value = "/CreateSearchTable",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public String CreateSearTable(@RequestBody SearchInfo searchInfo){
        System.out.println(searchInfo.toString());
//        if(searchInfo.getpName().equals("")){searchInfo.setpName(null);}
        return userSearchService.CreateSearchTable(searchInfo)+"";
    }

    @RequestMapping(value = "/GetPage/{PageNum}",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public PageInfo<UserSearch> GetProductPage(@PathVariable("PageNum") Integer Num, HttpServletRequest Req){
        String searchId = Req.getParameter("searchId");
        String userId = Req.getParameter("userId");
        PageInfo<UserSearch> page=userSearchService.GetUserSearchInfo(Num,4,searchId,userId);
        return page;
    }
}
