package com.CampusMall.Control;


import com.CampusMall.Pojo.User;
import com.CampusMall.Service.ServiceImpl.UserService;
import com.CampusMall.Service.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller

@RequestMapping("/User")
@CrossOrigin
public class UserControl {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public String Login(HttpServletRequest Req){
        String   UserId = Req.getParameter("UserId");
        String PassWord = Req.getParameter("PassWord");
        System.out.println(UserId+"||"+PassWord);
        String LoginMessage =userService.Login(UserId,PassWord);
        System.out.println(LoginMessage+"dasdsd");
        return LoginMessage;
    }
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public List<String> Register(@RequestBody User user){
       //User user = new User();
//       user.setUserAddress(Req.getParameter("UserAddress"));
//       user.setUserEmail(Req.getParameter("UserEmail"));
       //user.setUserForbid(Boolean.parseBoolean(Req.getParameter("UserForbid")));
       //user.setUserGender(Boolean.parseBoolean(Req.getParameter("UserGender")));
//       user.setUserName(Req.getParameter("UserName"));
//       user.setUserPassword(Req.getParameter("PassWord"));
       //user.setUserPhone(Long.valueOf(Req.getParameter("UserPhone")));Req.getParameter("UserName")
       //System.out.println(user.toString());
       String n =userService.Register(user);
       String Register="注册成功";
       List<String> list = new LinkedList<>();
       list.add(n);
       list.add(Register);
       return list;
    }
    @RequestMapping(value = "/Update", method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public String UpdateUser(@RequestBody User user){
        String UserId = user.getUserId();
        int i=userService.UpdateUserInfo(user,UserId);
        String UpdateMessage;
        if(i==0){
            UpdateMessage = "修改失败";
        }else{
            UpdateMessage = "修改成功";
        }
        return UpdateMessage;
    }
    @RequestMapping(value = "/GetUserInfo", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public User GetUserInfo(HttpServletRequest Req){
        String UserId = (String) Req.getParameter("userId");
        System.out.println(UserId);
        return userService.GetUserInfo(UserId);
    }
    @RequestMapping(value = "/GetUserInfo1", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<User> GetUserInfo1(HttpServletRequest Req){
        String UserId = (String) Req.getParameter("userId");
        System.out.println(UserId);
        List<User> user = new LinkedList<User>();
        user.add(userService.GetUserInfo(UserId));
        return user;
    }
    @RequestMapping(value = "/GetAllUser", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<User> GetAllUser(){
        return userService.getAllUser();
    }
    @RequestMapping(value = "/Forbid", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int Forbid(@RequestParam("userId") String UserId){
        User user= new User();
        user.setUserForbid(false);
        return userService.UpdateUserInfo(user,UserId);
    }
    @RequestMapping(value = "/NoForbid", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int NoForbid(@RequestParam("userId") String UserId){
        User user= new User();
        user.setUserForbid(true);
        return userService.UpdateUserInfo(user,UserId);
    }

}
