package com.moon.sell.service.impl;

import com.moon.sell.dataObject.OrderDetail;
import com.moon.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lhw
 * @date 2020/8/14
 */
@SpringBootTest
@Slf4j
class OrderMasterServiceTest {

    @Autowired
    private OrderMasterServiceImpl orderMasterService;
    private final String buyerOpenid = "ew3euwhd7sjw9diwkq";

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小明");
        orderDTO.setBuyerAddress("山东青岛");
        orderDTO.setBuyerPhone("119");
        orderDTO.setBuyerOpenid(buyerOpenid);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        OrderDetail o2 = new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(1);
        o2.setProductId("123458");
        o2.setProductQuantity(1);

        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO orderDTO1 = orderMasterService.create(orderDTO);
        log.info("【创建订单】 result: {}",orderDTO1);
    }

    @Test
    void findOne() {
        OrderDTO orderDTO = orderMasterService.findOne("1597410447857210538");
        System.out.println(orderDTO);
    }

    @Test
    void findList() {
        PageRequest request = PageRequest.of(0, 10);
        Page<OrderDTO> list = orderMasterService.findList(buyerOpenid, request);
        for(OrderDTO orderDTO:list){
            System.out.println(orderDTO);
        }
    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderMasterService.findOne("1597410447857210538");
        orderMasterService.cancel(orderDTO);
    }

    @Test
    void finish() {
        OrderDTO orderDTO = orderMasterService.findOne("1597410447857210538");
        orderMasterService.finish(orderDTO);
        System.out.println(orderDTO);
    }

    @Test
    void paid() {
        OrderDTO orderDTO = orderMasterService.findOne("1597410447857210538");
        orderMasterService.paid(orderDTO);
        System.out.println(orderDTO);
    }

    @Test
    void findList2() {
        PageRequest request = PageRequest.of(0, 10);
        Page<OrderDTO> list = orderMasterService.findList(request);
        for(OrderDTO orderDTO:list){
            System.out.println(orderDTO);
        }
        Assert.assertTrue(list.getTotalElements() > 0);
    }


}