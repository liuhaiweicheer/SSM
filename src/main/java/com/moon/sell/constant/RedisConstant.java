package com.moon.sell.constant;

/**
 *  Redis 常量  过期时间 2 hours
 * @author lhw
 * @date 2020/8/19
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200;

}
