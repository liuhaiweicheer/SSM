package com.moon.sell.dataObject;

import com.moon.sell.enums.ProductStatusEnum;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.omg.CORBA.INTERNAL;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lhw
 * @date 2020/8/14
 */
@Entity
@Data
@DynamicUpdate
@Proxy(lazy = false)
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus = ProductStatusEnum.UP.getCode();

    private Integer categoryType;

    private Date creatTime;

    private Date updateTime;


}
