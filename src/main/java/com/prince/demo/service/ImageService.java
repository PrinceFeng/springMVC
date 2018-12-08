package com.prince.demo.service;

import com.prince.demo.entity.Image;

import java.util.List;

/**
 * todo
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/30
 *
 **/
public interface ImageService {

    /**
     * 录入上传的图片信息
     *
     * @param image 图片对象
     */
    void insertImage(Image image);

    /**
     * 查询所有上传的图片
     *
     * @return  imageList
     */
    List<Image> queryImageList();
}
