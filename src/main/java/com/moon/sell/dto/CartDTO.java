package com.moon.sell.dto;

import lombok.Data;

/**
 * @author lhw
 * @date 2020/8/14
 */
@Data
public class CartDTO {

    //  商品 id
    private String productId;

    // 数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

//    public CartDTO() {
//    }
}
