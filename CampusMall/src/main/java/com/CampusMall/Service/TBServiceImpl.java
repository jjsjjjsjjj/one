package com.CampusMall.Service;

import com.CampusMall.Mapper.TBMapper;
import com.CampusMall.Pojo.TB;
import com.CampusMall.Service.ServiceImpl.TBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TBService")
public class TBServiceImpl implements TBService {
    @Autowired
    TBMapper tbMapper;
    @Override
    public int insert(TB tb) {
        return tbMapper.insertSelective(tb);
    }

    @Override
    public TB select(Long Id) {
        return tbMapper.selectByPrimaryKey(Id);
    }
}
