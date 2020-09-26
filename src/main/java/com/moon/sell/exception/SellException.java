package com.moon.sell.exception;

import com.moon.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @author lhw
 * @date 2020/8/14
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
