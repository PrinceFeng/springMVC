package com.prince.demo.dao;

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
public interface ImageDao {

    /**
     * 存储上传的图片信息
     *
     * @param image 图片对象
     */
    void insertImage(Image image);

    /**
     * 查询图片列表
     *
     * @return imageList
     */
    List<Image> queryImageList();


}
