package com.moon.sell.dataObject.dao;

import com.moon.sell.dataObject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author lhw
 * @date 2020/8/27
 */
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper categoryMapper;

    public int insertByMap(Map<String, Object> map){
        return categoryMapper.insertByMap(map);
    }


}
