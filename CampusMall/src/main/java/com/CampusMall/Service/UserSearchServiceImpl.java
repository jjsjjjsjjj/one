package com.CampusMall.Service;

import com.CampusMall.Mapper.ProductMapper;
import com.CampusMall.Mapper.UserSearchMapper;
import com.CampusMall.Pojo.*;
import com.CampusMall.Service.ServiceImpl.UserSearchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
@Service("userSearchService")
public class UserSearchServiceImpl implements UserSearchService {
    @Autowired
    UserSearchMapper userSearchMapper;
    @Autowired
    ProductMapper productMapper;
    @Override
    public PageInfo<UserSearch> GetUserSearchInfo(Integer PageNum,Integer PageSize,String searchId,String userId) {
        PageHelper.startPage(PageNum,PageSize);
        UserSearchExample example = new UserSearchExample();
        example.createCriteria().andUsersearchIdEqualTo(searchId).andUserIdEqualTo(userId);
        List<UserSearch> List=userSearchMapper.selectByExample(example);
        PageInfo<UserSearch> page=new PageInfo<UserSearch>(List,5);
        return page;
    }

    @Override
    public String CreateSearchTable(SearchInfo searchInfo) {
        //userSearchMapper.deleteByExample(null);
        int count=0;
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        if(searchInfo.getpName()!=null&&searchInfo.getpName().length()>0){
            criteria.andPNameLike("%"+searchInfo.getpName()+"%");
        }
        if(searchInfo.getTypeId()!=null&&searchInfo.getTypeId().length()>0){
            criteria.andPTypeEqualTo(searchInfo.getTypeId());
        }
        if(searchInfo.getPrice1()!=null&&searchInfo.getPrice2()!=null){
            criteria.andPPriceBetween(searchInfo.getPrice1(),searchInfo.getPrice2());
        }
        Long timeNew = System.currentTimeMillis()/1000;
        timeNew=timeNew+(int)((Math.random()*9+1)*1000);
        LocalDate date = LocalDate.now();
        String n="tus"+date.toString().split("-")[0]+date.toString().split("-")[1]+date.toString().split("-")[2]+String.valueOf(timeNew);
        List<Product> products = productMapper.selectByExample(productExample);
        //List<UserSearch> userSearches = new LinkedList<>();
        for(int i=0;i<products.size();i++){
            Product product = products.get(i);
            UserSearch userSearch  = new UserSearch();
            userSearch.setpId(product.getpId());
            userSearch.setpImg(product.getpImg());
            userSearch.setpName(product.getpName());
            userSearch.setpNum(product.getpNum());
            userSearch.setpPrice(product.getpPrice());
            userSearch.setpType(product.getpType());
            userSearch.setUserId(searchInfo.getUserId());
            userSearch.setUsersearchId(n);
            count=count+userSearchMapper.insertSelective(userSearch);
        }
        return n;
    }
}
