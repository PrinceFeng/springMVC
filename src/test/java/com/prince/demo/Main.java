package com.prince.demo;

import com.prince.demo.util.Uuid;

/**
 * 测试
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/30
 **/
public class Main {


    public static void main(String[] args) {
        System.out.println(Uuid.uuid());
        System.out.println(Uuid.uuid(8, 10));
        System.out.println(Uuid.uuid(8,1,9));
    }


}

