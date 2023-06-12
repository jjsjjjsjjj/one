package com.CampusMall.Service;

import com.CampusMall.Mapper.UserMapper;
import com.CampusMall.Pojo.User;
import com.CampusMall.Pojo.UserExample;
import com.CampusMall.Service.ServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        //UserExample userExample=new UserExample();
        return userMapper.selectByExample(null);
    }
    //用户登录功能
    public String Login(String UserId,String Password){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(UserId);
        //User user =  userMapper.selectByExample(userExample).get(0);
        if(userMapper.selectByExample(userExample).size()<=0) {
            return "不能存在该用户";
        }else{

            List<User> list= userMapper.selectByExample(userExample);
            User user=list.get(0);
            if(user.getUserForbid()){
                userExample.clear();
                userExample.createCriteria().andUserPasswordEqualTo(Password).andUserIdEqualTo(UserId);
                System.out.println("这是Service层的检测");
                if(userMapper.selectByExample(userExample).size()<=0){
                    return "密码错误";
                }else {
                    return "验证成功";
                }
            }else{
                return "禁用";
            }

        }
    }
    //用户注册功能
    public String Register(User user){//注册用户
        Long timeNew = System.currentTimeMillis()/1000;
        timeNew=timeNew+(int)((Math.random()*9+1)*1000);
        LocalDate date = LocalDate.now();
        String n=date.toString().split("-")[0]+date.toString().split("-")[1]+date.toString().split("-")[2]+String.valueOf(timeNew)+"1110";
        user.setUserId(n);//构建唯一标识
        userMapper.insertSelective(user);
        return n;
    }
    //获取用户的信息
    public User GetUserInfo(String UserId){//获取资料和基本信息
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(UserId);
        return userMapper.selectByExample(userExample).get(0);
    }
    //修改用户的信息包括密码
    public int UpdateUserInfo(User user,String UserId){//修改资料和基本信息
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(UserId);
        return userMapper.updateByExampleSelective(user,userExample);
    }
}
