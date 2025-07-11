package com.px.partybuild.util;

/**
 *
 * uuid工具类
 * create by huang.l 2019.8.22 15.54
 */
public class UUIDUtils {

    public static String getUUID(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","");
    }

}
