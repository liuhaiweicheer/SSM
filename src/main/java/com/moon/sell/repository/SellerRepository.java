package com.moon.sell.repository;

import com.moon.sell.dataObject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lhw
 * @date 2020/8/18
 */
public interface SellerRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

}
