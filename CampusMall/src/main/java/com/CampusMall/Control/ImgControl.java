package com.CampusMall.Control;


import com.CampusMall.Service.ServiceImpl.TBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/Img")
@CrossOrigin
public class ImgControl {
    @Autowired
    TBService tbService;
    @RequestMapping(value = "/Get",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public String get(MultipartFile file, HttpServletRequest Req)  {
        String oFileName = file.getOriginalFilename();
        String suffix=oFileName.substring(oFileName.lastIndexOf("."));
        String fileName=UUID.randomUUID().toString()+suffix;
        try {
            //临时文件转存
            file.transferTo(new File("D:\\img\\"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
    @RequestMapping(value = "/GetP",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public void getP(@RequestParam("name")  String name, HttpServletResponse response){

        try {
            //输入流
            FileInputStream fileInputStream = new FileInputStream(new File("D:\\img\\"+name));
            //输出流
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("img/jpeg");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes))!=-1 ){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
