package com.prince.demo.controller;

import com.prince.demo.Constants;
import com.prince.demo.entity.Image;
import com.prince.demo.service.ImageService;
import com.prince.demo.util.ImageUtil;
import com.prince.demo.util.Uuid;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * 上传文件
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/26
 **/
@Controller
@RequestMapping("/file")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile[] multipartFile) throws IOException {

        if (multipartFile != null && multipartFile.length > 0) {

            for(MultipartFile mf : multipartFile) {

                String originFileName = mf.getOriginalFilename();
                String newFileName = ImageUtil.getRandomFileName() + originFileName.substring(originFileName.lastIndexOf("."));

                // 本地图片服务器
                // String filePath = Constants.LOCAL_IMAGE_SERVER + newFileName;
                // 远程图片服务器
                String filePath = Constants.REMOTE_IMAGE_SERVER + newFileName;

                // 将图片上传到图片服务器
                Client client = new Client();
                WebResource webResource = client.resource(filePath);
                webResource.put(mf.getBytes());

                // 上传的图片存入数据库
                String imgId = Uuid.uuid(8, 10);
                String imgTag = "image";
                String imgDesc = "这是一张图片";
                Date now = new Date();

                Image image = new Image();
                image.setImgId(imgId);
                image.setImgName(newFileName);
                image.setImgTag(imgTag);
                image.setImgDescription(imgDesc);
                image.setImgCreateTime(now);
                image.setImgUpdateTime(now);

                imageService.insertImage(image);
            }

        }

        return "success";

    }

    @RequestMapping(value = "/imageList")
    @ResponseBody
    public Map<String, Object> imageList() {
        Map<String, Object> modelMap = new HashMap<>();

        List<Image> imageList = new ArrayList<>();

        imageList = imageService.queryImageList();

        modelMap.put("imageList", imageList);

        return modelMap;


    }

    @RequestMapping(value = "/upload")
    public String hello() {
        return "uploadfile";
    }


}
