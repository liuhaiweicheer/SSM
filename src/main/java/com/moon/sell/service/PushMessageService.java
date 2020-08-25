package com.moon.sell.service;

import com.moon.sell.dto.OrderDTO;

/**
 * @author lhw
 * @date 2020/8/25
 */

public interface PushMessageService {

    /**
     * 订单状态变更信息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);

}
