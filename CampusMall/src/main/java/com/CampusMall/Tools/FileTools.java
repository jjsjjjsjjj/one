package com.CampusMall.Tools;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.util.UUID;

public class FileTools {
    //图片上传的返回值就是图片上传之后的新名称
    public static String uploadFile(MultipartFile picture, HttpServletRequest request) {
        //现在的工作是：想办法把用户传过来的文件存储到我们的电脑中
        //先得到原图片的图片名
        String fileName = picture.getOriginalFilename();
        try {
            //得到用户存文件的路径,其实就是项目在我们电脑中的位置
            //realPath就是当前项目在我们电脑硬盘中的位置
            String realPath = request.getSession().getServletContext().getRealPath("/");
            //通过项目目录和图片文件夹名创建一个文件对象
            System.out.println(realPath);
            File file = new File(realPath + "images/");
            //注意，java中的文件对象，不会帮我们自动创建文件夹
            //判断该文件夹是否存在，如果已经存在，不创建
            if (!file.exists()) {
                //mkdir    创建文件夹
                file.mkdir();
            }
            //现在我们将图片根据路径存到文件夹中之前需要将图片重命名
            //UUID 生成32位不重复的字母-数字的字符串
            //fileName  == >    彪.jpg
            UUID randomUUID = UUID.randomUUID();
            //先将原文件的后缀名取出来
            String houzhui = fileName.substring(fileName.lastIndexOf("."));
            //将UUID和原文件后缀拼接在一起
            fileName = randomUUID + houzhui;
            picture.transferTo(new File(realPath + "images/" + fileName));
            //将文件名传回给前端
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //直接将文件夹名称和图片名拼在一起返回
        return "images/" + fileName;
    }

    //下载

    //图片上传的返回值就是图片上传之后的新名称 G:\tianman\library-management-system-master\library-management-system-master\tmsy\target\tmsy\images/aaa.png
    public static void downlodFile(String imgName, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getSession().getServletContext().getRealPath("/");

        //获取完整路径
        String allName = realPath + imgName;
        File file = new File(allName);
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename=" + imgName);
        try {
            Files.copy(file.toPath(), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
