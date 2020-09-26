package com.moon.sell.dataObject.mapper;

import com.moon.sell.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/27
 */
@SpringBootTest
class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "我的最爱");
        map.put("category_type", 111);
        int i = mapper.insertByMap(map);
        Assert.assertEquals(1,i);
    }

    @Test
    public void insertByObjectTest(){
        ProductCategory productCategory = new ProductCategory("我的最不爱",113);
        int i = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,i);
    }

    @Test
    public void findByCategoryTypeTest(){
        ProductCategory byCategoryType = mapper.findByCategoryType(11);
        System.out.println(byCategoryType);
    }


    @Test
    public void findByCategoryNameTest(){
        List<ProductCategory> byCategoryType = mapper.findByCategoryName("女生最爱");
        System.out.println(byCategoryType.size());
    }

    @Test
    public void updateByCategoryType(){

        int i = mapper.updateByCategoryType("女生最不爱", 22);
        Assert.assertEquals(1,i);
    }


    @Test
    public void updateByObject(){
        ProductCategory productCategory = new ProductCategory("我的最爱",22    );
        int i = mapper.updateByObject(productCategory);
        Assert.assertEquals(1,i);
    }


}