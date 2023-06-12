package com.CampusMall.Service.ServiceImpl;

import com.CampusMall.Pojo.Admin;
import com.CampusMall.Pojo.AdminExample;

import java.util.List;

public interface AdminService {
    public List<Admin> SelectAdmin(AdminExample example);
    public int insertAdmin(Admin admin);
    public int delete(String  AdminId);
    public int update(AdminExample example,Admin admin);
    public String Login(String  AdminId,String Password);
    //public int changeForbid(Long AdminId);
}
