package com.moon.sell.converter;

import com.moon.sell.dataObject.OrderMaster;
import com.moon.sell.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lhw
 * @date 2020/8/15
 */
public class OrderMaster2OrderDTOConvert {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList = orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return orderDTOList;
    }

}
