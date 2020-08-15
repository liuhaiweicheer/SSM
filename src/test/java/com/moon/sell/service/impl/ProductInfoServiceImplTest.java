package com.moon.sell.service.impl;

import com.moon.sell.dataObject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/14
 */
@SpringBootTest
class ProductInfoServiceImplTest {

    @Autowired
     ProductInfoServiceImpl productInfoService;

    @Test
    void findOne() {
                ProductInfo one = productInfoService.findOne("123456");
        System.out.println(one);
    }

    @Test
    void findUPAll() {
    }

    @Test
    void findAll() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> all = productInfoService.findAll(request);
        long totalElements = all.getTotalElements();
        System.out.println(totalElements);
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("皮皮虾很好吃");
        productInfo.setProductIcon("http://xxxxxx");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        productInfoService.save(productInfo);
    }
}