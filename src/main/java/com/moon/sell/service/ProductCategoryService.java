package com.moon.sell.service;

import com.moon.sell.dataObject.ProductCategory;

import java.util.List;

/**
 * @author lhw
 * @date 2020/8/14
 */

public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

    ProductCategory save(ProductCategory productCategory);

}
