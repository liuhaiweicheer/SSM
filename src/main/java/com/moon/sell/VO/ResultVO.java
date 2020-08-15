package com.moon.sell.VO;

import lombok.Data;

/**
 * @author lhw
 * @date 2020/8/14
 */
@Data
public class ResultVO <T>{

    //   错误码
    private Integer code;

    //  信息
    private String msg = "";

    // 数据
    private T data;

}
