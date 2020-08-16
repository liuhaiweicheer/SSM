package com.moon.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author lhw
 * @date 2020/8/16
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object); 
    }

}
