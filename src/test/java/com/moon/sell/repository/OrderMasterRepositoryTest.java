package com.moon.sell.repository;

import com.moon.sell.dataObject.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.ObjectInputValidation;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/14
 */
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderMaster> masterPage = repository.findByBuyerOpenid("abcdefg", request);
        List<OrderMaster> content = masterPage.getContent();
        for(OrderMaster orderMaster:content){
            System.out.println(orderMaster);
        }
    }

    @Test
    public void saveTest(){
        OrderMaster orderMaster = repository.getOne("100001");
        orderMaster.setBuyerPhone("110");
        repository.save(orderMaster);
    }

}