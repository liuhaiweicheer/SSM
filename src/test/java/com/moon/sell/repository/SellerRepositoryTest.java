package com.moon.sell.repository;

import com.moon.sell.dataObject.SellerInfo;
import com.moon.sell.utils.KeyUtil;
import com.sun.org.apache.xml.internal.security.keys.KeyUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/18
 */
@SpringBootTest
class SellerRepositoryTest {

    @Autowired
    SellerRepository sellerRepository;

    @Test
    void testSave(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("wqsadasdfasdas");
        sellerInfo.setPassword("123456");
        sellerInfo.setUsername("liuhaiwei");
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        SellerInfo save = sellerRepository.save(sellerInfo);
        Assert.assertNotNull(save);
    }

    @Test
    void findByOpenid() {
        SellerInfo sellerInfo = sellerRepository.findByOpenid("wqsadasdfasdas");
        Assert.assertNotNull(sellerInfo);
        Assert.assertNotNull("wqsadasdfasdas", sellerInfo.getOpenid());
    }
}