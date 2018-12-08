package com.prince.demo.util;

import java.util.Random;

/**
 * 生成随机串工具类
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/30
 **/
public class Uuid {

    private static final char[] CHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };


    /**
     * 生成36位的包含大小写字母+数字的随机串
     *
     * @return 随机字符串
     */
    public static String uuid() {
        char[] uuid = new char[36];

        uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
        uuid[14] = '4';

        Random rand = new Random();
        for (int i = 0; i < 36; i++) {
            if (uuid[i] <= 0) {
                int r = rand.nextInt(16) % 16;
                uuid[i] = CHARS[(i == 19) ? (r & 0x3) | 0x8 : r];
            }
        }
        return new String(uuid);
    }

    /**
     *  定制随机串，指定其包含的长度和内容
     *
     * @param length  生成随机串的长度
     * @param redix  随机串包含的内容：10 只包含数字0~9； 36 包含数字和小写字母； 0 包含大小写字母+数字
     * @return 随机字符串
     */
    public static String uuid(int length, int redix) {

        int r = redix <= 0 || redix > CHARS.length ? CHARS.length : redix;
        int l = length <= 0 ? 18 : length;

        char[] uuid = new char[length];

        Random rand = new Random();
        for (int i = 0; i < l; i++) {
            uuid[i] = CHARS[rand.nextInt(r) % r];
        }

        return new String(uuid);
    }


    /**
     * 精确定制随机串，指定其长度和包含的字符内容
     * 
     * @param length  生成随机串的长度
     * @param start  指定起始位置，以指定随机串包含的内容
     * @param end  指定结束位置，以指定随机串包含的内容
     * @return  生成的随机字符串
     */
    public static String uuid(int length,int start,int end){

        int e = end < 0 || end >= CHARS.length ? CHARS.length - 1 : end;
        int s = start < 0 || start >= e ? e: start;
        int l = length <= 0 ? 18 : length;

        char [] uuid = new char[length];

        Random rand = new Random();
        for (int i = 0 ;i < l ; i ++){
            uuid[i] = CHARS[s + rand.nextInt(e - s + 1) % (e - s + 1)];
        }

        return new String(uuid);
    }
}
