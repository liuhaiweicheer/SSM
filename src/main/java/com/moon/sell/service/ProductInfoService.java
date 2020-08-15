package com.moon.sell.service;

import com.moon.sell.dataObject.ProductInfo;
import com.moon.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author lhw
 * @date 2020/8/14
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     *  查询左右在线的
     * @return
     */
    List<ProductInfo> findUPAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
