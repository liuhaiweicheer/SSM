package com.moon.sell.enums;

import lombok.Getter;

/**
 * @author lhw
 * @date 2020/8/14
 */
@Getter
public enum PayStatusEnum implements CodeEnum<Integer> {
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功")
    ;


    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
