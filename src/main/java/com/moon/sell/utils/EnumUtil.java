package com.moon.sell.utils;

import com.moon.sell.enums.CodeEnum;

/**
 * @author lhw
 * @date 2020/8/16
 */
public class EnumUtil {

   public static <T extends CodeEnum<Integer>, K> T  getByCode(K code, Class<T> enumClass){
       for(T each:enumClass.getEnumConstants()){
           if(code.equals(each.getCode())){
               return each;
           }
       }
       return null;

   }

}
