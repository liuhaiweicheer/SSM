package com.moon.sell.service.impl;

import com.moon.sell.dataObject.SellerInfo;
import com.moon.sell.repository.SellerRepository;
import com.moon.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhw
 * @date 2020/8/18
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        SellerInfo sellerInfo = sellerRepository.findByOpenid(openid);
        return sellerInfo;
    }
}
