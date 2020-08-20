package com.moon.sell.controller;

import com.moon.sell.constant.CookieConstant;
import com.moon.sell.constant.RedisConstant;
import com.moon.sell.dataObject.SellerInfo;
import com.moon.sell.enums.ResultEnum;
import com.moon.sell.service.SellerService;

import com.moon.sell.utils.CookieUtil;
import org.apache.http.cookie.CookieIdentityComparator;
import org.aspectj.bridge.MessageWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.pkcs11.P11Util;

import javax.jws.Oneway;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lhw
 * @date 2020/8/19
 */

@RequestMapping("/seller")
@Controller
public class SellerUserController {

    @Autowired
    private SellerService sellerService;


    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              Map<String, Object> map,
                              HttpServletResponse response){
        //   拿 openid 去数据中匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if(sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_ERROR.getMsg());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        //  设置 token 到 redis
        String token = UUID.randomUUID().toString();
//        redisTemplate.opsForValue().set(token,"dasdasdsadasdasdasd");
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token), openid,expire, TimeUnit.SECONDS);
        // 设置 token 到 cookie

        CookieUtil.set(response, CookieConstant.TOKEN, token, 20);

        return new ModelAndView("redirect:/seller/order/list");
    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                             HttpServletResponse response,
                             Map<String, Object> map){
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie != null){
            //  清除 redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            // 清除 cookie
            CookieUtil.set(response,CookieConstant.TOKEN, null, 0);
            map.put("msg",ResultEnum.LOGOUT_SUCCESS);
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/success", map);
        }
        return null;
    }
}
