package com.cxhu.comprehensive.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/*文件上传*/

@Controller
public class FileUpLoadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUpLoadController.class);

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public void uploadPicture(HttpServletRequest request) throws Exception {
        // 构建一个上传的文件的 存放路径
        String path = request.getServletContext().getRealPath("/");
        path = path.replace("webapp\\", "") + "resources\\static\\upload_file";
        File dir = new File(path);
        if (!dir.exists()) {		// 如果没有, 则创建文件夹
            dir.mkdir();
        }
        
        logger.debug("path=" + path);
        request.setCharacterEncoding("utf-8");  //设置编码
        
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("up_file");
        
        String videoName = request.getParameter("videoName");
        
        File dest = new File(dir, videoName);
		multipartFile.transferTo(dest);
        
    }
}
