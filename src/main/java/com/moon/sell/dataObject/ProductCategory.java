package com.moon.sell.dataObject;

import com.sun.xml.txw2.DatatypeWriter;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author lhw
 * @date 2020/8/14
 */

@Data
@Entity
@Proxy(lazy = false)   //  Hibernate 默认是开启懒加载的 我们关闭懒加载
@DynamicUpdate      //  因为设置了更新时间， 我们获取了时间每次更新时不会被会覆盖
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 自增  springboot 2.+ 需要显示配置自增
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date creatTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }


}
