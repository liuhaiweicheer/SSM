package com.moon.sell.repository;

import com.moon.sell.dataObject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/14
 */

@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository repository;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxxxxx");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        repository.save(productInfo);

    }

    @Test
    void findByProductStatus() {
        List<ProductInfo> byProductStatus = repository.findByProductStatus(0);
        for(ProductInfo productInfo:byProductStatus){
            System.out.println(productInfo);
        }
    }

    @Test
    public void findOneTest(){
        ProductInfo one = repository.getOne("123456");
        System.out.println(one);
    }

}