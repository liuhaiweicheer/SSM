package com.moon.sell.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.moon.sell.VO.ProductInfoVO;
import com.moon.sell.VO.ProductVO;
import com.moon.sell.VO.ResultVO;
import com.moon.sell.dataObject.ProductCategory;
import com.moon.sell.dataObject.ProductInfo;
import com.moon.sell.service.ProductCategoryService;
import com.moon.sell.service.ProductInfoService;
import com.moon.sell.utils.ResultVOUtil;
import org.aspectj.bridge.MessageWriter;
import org.hibernate.collection.internal.PersistentList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lhw
 * @date 2020/8/14
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        // 1.查询所有 上架的商品
        List<ProductInfo> productInfoServiceUPAll = productInfoService.findUPAll();
        // 2.查询类目
//        List<Integer> categoryList = new ArrayList<>();
        // 传统方法
//        for(ProductInfo productInfo:productInfoServiceUPAll){
//            categoryList.add(productInfo.getCategoryType());
//        }

        //Java8 精简方法  Lambda 表达式
        List<Integer> categoryList = productInfoServiceUPAll.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);

        // 3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();

        for(ProductCategory productCategory: productCategoryList ){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO>  productInfoVOList = new ArrayList<>();

            for(ProductInfo productInfo: productInfoServiceUPAll){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                     ProductInfoVO productInfoVO = new ProductInfoVO();
                     /* 对两个类中相似的属性赋值 */
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);

                }
            }
            productVO.setProductInfoVOS(productInfoVOList);
            productVOList.add(productVO);
        }

//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(1);
//        resultVO.setMsg("成功");
//        resultVO.setData(Arrays.asList( productVOList));
//        return resultVO;
        return ResultVOUtil.success(productVOList);
    }

}
