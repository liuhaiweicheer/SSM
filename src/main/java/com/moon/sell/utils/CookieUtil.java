package com.moon.sell.utils;

import com.moon.sell.constant.CookieConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lhw
 * @date 2020/8/19
 */
public class CookieUtil {

    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);

    }

    public static Cookie get(HttpServletRequest request,
                           String name){
        Map<String, Cookie> map = readCookie(request);
        if (map.containsKey(name)){
            return map.get(name);
        }else {
            return null;
        }

    }

    private  static Map<String, Cookie>  readCookie(HttpServletRequest request){
        Map<String, Cookie> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                map.put(cookie.getName(), cookie);
            }
        }
        return map;
    }

}
