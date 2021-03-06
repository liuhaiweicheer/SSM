package com.moon.sell.service;

import com.moon.sell.dataObject.OrderMaster;
import com.moon.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author lhw
 * @date 2020/8/14
 */
public interface OrderMasterService {

    /**
     *  创建订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     *  查询单个订单
     */
    OrderDTO findOne(String orderId);

    /**
     *  查询的订单列表
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     *  取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     *  完结订单
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     *  支付订单
     *
     */
    OrderDTO paid(OrderDTO orderDTO);

    Page<OrderDTO> findList(Pageable pageable);

}
