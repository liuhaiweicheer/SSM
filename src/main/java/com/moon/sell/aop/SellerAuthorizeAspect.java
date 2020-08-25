package com.moon.sell.aop;

import com.moon.sell.constant.CookieConstant;
import com.moon.sell.constant.RedisConstant;
import com.moon.sell.exception.SellerAuthorizeException;
import com.moon.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lhw
 * @date 2020/8/20
 */
@Slf4j
@Component
@Aspect
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.moon.sell.controller.Seller*.*(..))" + "&& !execution(public * com.moon.sell.controller.SellerUserController.*(..))")
    public void verify(){

    }

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie == null){
            log.warn("没有Cookie");
            throw new SellerAuthorizeException();
        }

        //   去 Redis 里面查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie));
        if(StringUtils.isEmpty(tokenValue)){
            log.warn("登陆校验");
            throw new SellerAuthorizeException();
        }



    }

}
