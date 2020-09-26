package com.moon.sell.dataObject.mapper;

import com.moon.sell.dataObject.ProductCategory;
import com.moon.sell.enums.CodeEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author lhw
 * @date 2020/8/27
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name, category_type) values (#{category_name, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category(category_name, category_type) values (#{categoryName}, #{categoryType})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where  category_type=#{categoryType}")
    @Results({
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_id", property = "categoryId")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where  category_name=#{categoryName}")
    @Results({
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_id", property = "categoryId")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName, @Param("categoryType")Integer categoryType); //  多个参数 使用 @Param


    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory); //  多个参数 使用 @Param

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);




}
