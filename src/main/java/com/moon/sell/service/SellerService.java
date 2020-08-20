package com.moon.sell.service;

import com.moon.sell.dataObject.SellerInfo;

/**
 * @author lhw
 * @date 2020/8/18
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);

}
