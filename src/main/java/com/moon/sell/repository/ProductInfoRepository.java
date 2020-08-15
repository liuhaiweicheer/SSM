package com.moon.sell.repository;

import com.moon.sell.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lhw
 * @date 2020/8/14
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo>findByProductStatus(Integer productStatus);

}
