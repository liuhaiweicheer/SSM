package com.moon.sell.utils;

import java.util.Random;

/**
 * @author lhw
 * @date 2020/8/14
 */
public class KeyUtil {

    /**
     *  生成唯一主键
     *  格式： 时间加随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
