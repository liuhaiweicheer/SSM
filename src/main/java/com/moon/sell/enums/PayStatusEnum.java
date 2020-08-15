package com.moon.sell.enums;

import lombok.Getter;
import org.springframework.data.domain.PageRequest;

/**
 * @author lhw
 * @date 2020/8/14
 */
@Getter
public enum PayStatusEnum {
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
