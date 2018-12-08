package com.prince.demo.entity;

import java.util.Date;

/**
 * 图片实体类
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/30
 **/

public class Image {
    private String imgId;
    private String imgName;
    private String imgTag;
    private String imgDescription;
    private Date imgCreateTime;
    private Date imgUpdateTime;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgTag() {
        return imgTag;
    }

    public void setImgTag(String imgTag) {
        this.imgTag = imgTag;
    }

    public String getImgDescription() {
        return imgDescription;
    }

    public void setImgDescription(String imgDescription) {
        this.imgDescription = imgDescription;
    }

    public Date getImgCreateTime() {
        return imgCreateTime;
    }

    public void setImgCreateTime(Date imgCreateTime) {
        this.imgCreateTime = imgCreateTime;
    }

    public Date getImgUpdateTime() {
        return imgUpdateTime;
    }

    public void setImgUpdateTime(Date imgUpdateTime) {
        this.imgUpdateTime = imgUpdateTime;
    }
}
