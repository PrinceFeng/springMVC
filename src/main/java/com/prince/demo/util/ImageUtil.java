package com.prince.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 图片工具类
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/12/3
 **/
public class ImageUtil {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random RANS = new Random();

    /**
     * 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @return 随机文件名
     */
    public static String getRandomFileName() {
        int nums = RANS.nextInt(89999) + 10000;
        String nowStr = SIMPLE_DATE_FORMAT.format(new Date());

        return nowStr + nums;

    }

    public static void main(String[] args) {
        System.out.println(getRandomFileName());
    }
}
