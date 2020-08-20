package com.moon.sell.controller;

import com.lly835.bestpay.rest.type.Get;
import com.lly835.bestpay.rest.type.Post;
import com.moon.sell.dataObject.ProductCategory;
import com.moon.sell.form.CategoryForm;
import com.moon.sell.repository.ProductCategoryRepository;
import com.moon.sell.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Map;

/**
 * @author lhw
 * @date 2020/8/18
 */
@Slf4j
@RequestMapping("/seller/category")
@Controller
public class SellerCategoryController {

    @Autowired
    private ProductCategoryService  productCategoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){
        List<ProductCategory> all = productCategoryService.findAll();
        map.put("categoryList",  all);

        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String, Object> map){
        if(categoryId != null ){
            ProductCategory productCategory = productCategoryService.findOne(categoryId);
            map.put("category", productCategory);
        }
        return new ModelAndView("category/index",map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm, BindingResult result, Map<String, Object> map){
        if(result.hasErrors()){
            log.info("订单类型保存出错{}",result.getFieldError().getDefaultMessage());
            map.put("msg",result.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        ProductCategory productCategory = new ProductCategory();
        try {
            if(categoryForm.getCategoryId() == null){
                BeanUtils.copyProperties(categoryForm, productCategory);
            }else{
                productCategory = productCategoryService.findOne(categoryForm.getCategoryId());
                BeanUtils.copyProperties(categoryForm,productCategory);
            }
            productCategoryService.save(productCategory);
        } catch (BeansException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }

}
