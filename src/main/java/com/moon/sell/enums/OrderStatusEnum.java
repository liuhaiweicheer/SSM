package com.moon.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author lhw
 * @date 2020/8/14
 */
@Getter
public enum  OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"取消")
    ;

    private Integer code;
    private String msg;
    OrderStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
