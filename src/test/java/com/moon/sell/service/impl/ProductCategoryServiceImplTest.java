package com.moon.sell.service.impl;

import com.moon.sell.dataObject.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/14
 */

@SpringBootTest
class ProductCategoryServiceImplTest {

    @Autowired
    ProductCategoryServiceImpl productCategoryService;

    @Test
    void findOne() {
        ProductCategory one = productCategoryService.findOne(1);
        System.out.println();
    }

    @Test
    void findAll() {
        List<ProductCategory> categoryList = productCategoryService.findAll();
        for(ProductCategory productCategory : categoryList){
            System.out.println(productCategory);
        }
    }

    @Test
    void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1,2,3);
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(list);
        for(ProductCategory productCategory : categoryList){
            System.out.println(productCategory);
        }
    }

    @Test
    void save() {
        ProductCategory productCategory = new ProductCategory("男生最爱",3);
        productCategoryService.save(productCategory);
    }
}