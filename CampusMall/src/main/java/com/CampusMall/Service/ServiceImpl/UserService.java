package com.CampusMall.Service.ServiceImpl;

import com.CampusMall.Pojo.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public String Login(String  UserId,String Password);
    public String  Register(User user);
    public User GetUserInfo(String  UserId);
    public int UpdateUserInfo(User user,String  UserId);
}
