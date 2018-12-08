package com.prince.demo.service.impl;

import com.prince.demo.dao.ImageDao;
import com.prince.demo.entity.Image;
import com.prince.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * todo
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/30
 **/
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public void insertImage(Image image) {
        imageDao.insertImage(image);
    }

    @Override
    public List<Image> queryImageList() {
        List<Image> imageList = imageDao.queryImageList();

        return imageList;
    }
}
