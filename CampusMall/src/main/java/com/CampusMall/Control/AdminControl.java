package com.CampusMall.Control;

import com.CampusMall.Pojo.Admin;
import com.CampusMall.Pojo.AdminExample;
import com.CampusMall.Service.ServiceImpl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Admin")
@CrossOrigin
public class AdminControl {
    @Autowired
    AdminService adminService;
//    public List<Admin> SelectAdmin(AdminExample example);
//    public int insertAdmin(Admin admin);
//    public int delete(Long AdminId);
//    public int update(AdminExample example,Admin admin);
//    public String Login(Long AdminId,String Password);
    @RequestMapping(value = "/GetAllAdmin",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<Admin> GetAllAdmin(){
        return adminService.SelectAdmin(null);
    }
    @RequestMapping(value = "/insertAdmin",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public int insertAdmin(@RequestBody Admin admin){
        return adminService.insertAdmin(admin);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int delete(HttpServletRequest Req){
        String  AdminId = Req.getParameter("adminId");
        return adminService.delete(AdminId);
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int update(HttpServletRequest Req){
        String AdminId = Req.getParameter("AdminId");
        AdminExample example = new AdminExample();
        example.createCriteria().andAdminIdEqualTo(AdminId);
        Admin admin = new Admin();
        admin.setAdminForbid(Boolean.getBoolean(Req.getParameter("Forbid")));
        admin.setAdminName(Req.getParameter("AdminName"));
        admin.setAdminPassword(Req.getParameter("AdminPassWord"));
        admin.setAtypeId(Req.getParameter("ATypeId"));
        return adminService.update(example,admin);
    }
    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public String Login(HttpServletRequest Req){
        String AdminPassWord=Req.getParameter("AdminPassWord");
        String AdminId = Req.getParameter("AdminId");
        String Message=adminService.Login(AdminId,AdminPassWord);
        return Message;
    }
    @RequestMapping(value = "/Forbid", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int Forbid(@RequestParam("adminId") String AdminId){
        Admin admin= new Admin();
        admin.setAdminForbid(false);
        AdminExample example = new AdminExample();
        example.createCriteria().andAdminIdEqualTo(AdminId);
        return adminService.update(example,admin);
    }
    @RequestMapping(value = "/NoForbid", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public int NoForbid(@RequestParam("adminId") String AdminId){
        Admin admin= new Admin();
        admin.setAdminForbid(true);
        AdminExample example = new AdminExample();
        example.createCriteria().andAdminIdEqualTo(AdminId);
        return adminService.update(example,admin);
    }
}
