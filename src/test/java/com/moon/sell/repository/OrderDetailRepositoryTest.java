package com.moon.sell.repository;

import com.moon.sell.dataObject.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/14
 */
@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;
    
    @Test
    void findByOrOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrOrderId("100001");
        for(OrderDetail orderDetail:orderDetailList){
            System.out.println(orderDetail);
        }
    }
}