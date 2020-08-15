package com.moon.sell.repository;

import com.moon.sell.dataObject.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/14
 */
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    ProductCategoryRepository repository;

    @Test
    public void test01(){

        ProductCategory one = repository.getOne(1);
        System.out.println(one);
    }

    @Test
    public void saveTest()
    {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory = repository.getOne(2);
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(4);
        //  因为设置了更新时间， 我们获取了时间每次更新时会覆盖
        repository.save(productCategory);
    }

    @Test
    @Transactional    // 测试完之后数据库中不会有测试的数据
    public void saveTest2(){
        ProductCategory productCategory = new ProductCategory("男生最爱", 5);
        ProductCategory save = repository.save(productCategory);
        Assert.notNull(save);
    }

    @Test
    public void testFindByCategoryTypeInAnd(){
        List<Integer> list = Arrays.asList(2,4);
        List<ProductCategory> categoryList = repository.findByCategoryTypeIn(list);
//        System.out.println(categoryList.get(0));
        Assert.notEmpty(categoryList, "查询失败");
//        Assert.

    }


}