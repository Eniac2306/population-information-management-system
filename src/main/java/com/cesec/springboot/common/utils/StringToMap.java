package com.cesec.springboot.common.utils;

import java.util.HashMap;

/**
 * String 转 map
 */
public class StringToMap {
    public HashMap ToMap(String ex){
        HashMap map=new HashMap();
        if(ex!=null&&ex!=""){
            ex = ex.substring(1, ex.length() - 1);
            String string[] = ex.split(",");
            int lenth = string.length;
            for(int i=0;i<lenth;i++){
                String key=string[i].split("=")[0];
                String value=string[i].split("=")[1];
                map.put(key,value);
            }
        }
        return  map;
    }
}
