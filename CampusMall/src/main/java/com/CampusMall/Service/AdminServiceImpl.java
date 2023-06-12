package com.CampusMall.Service;

import com.CampusMall.Mapper.AdminMapper;
import com.CampusMall.Pojo.Admin;
import com.CampusMall.Pojo.AdminExample;
import com.CampusMall.Service.ServiceImpl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("AdminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Admin> SelectAdmin(AdminExample example) {
        return adminMapper.selectByExample(example);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int delete(String  AdminId) {
        AdminExample example=new AdminExample();
        example.createCriteria().andAdminIdEqualTo(AdminId);
        return adminMapper.deleteByExample(example);
    }

    @Override
    public int update(AdminExample example, Admin admin) {
        return adminMapper.updateByExampleSelective(admin,example);
    }

    @Override
    public String Login(String  AdminId, String Password) {
        AdminExample Example = new AdminExample();
        Example.createCriteria().andAdminIdEqualTo(AdminId);
        if(adminMapper.selectByExample(Example).size()<=0) {
            return "不存在该管理员";
        }else{
            List<Admin> list= adminMapper.selectByExample(Example);
            Admin admin=list.get(0);
            if(admin.getAdminForbid()){
                Example.clear();
                Example.createCriteria().andAdminPasswordEqualTo(Password).andAdminIdEqualTo(AdminId);
                if(adminMapper.selectByExample(Example).size()<=0){
                    return "密码错误";
                }else {
                    return ""+admin.getAtypeId();
                }
            }else{
                return "禁用";
            }

        }
    }


}
