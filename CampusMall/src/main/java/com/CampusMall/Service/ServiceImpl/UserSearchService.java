package com.CampusMall.Service.ServiceImpl;

import com.CampusMall.Pojo.SearchInfo;
import com.CampusMall.Pojo.UserSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserSearchService {
    public PageInfo<UserSearch> GetUserSearchInfo(Integer PageNum,Integer PageSize,String searchId,String userId);
    public String CreateSearchTable(SearchInfo searchInfo);
}
