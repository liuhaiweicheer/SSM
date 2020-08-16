package com.moon.sell.controller;

import com.moon.sell.dto.OrderDTO;
import com.moon.sell.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author lhw
 * @date 2020/8/16
 */
@RequestMapping("/seller/order")
@Controller
public class SellerOrderController {

    @Autowired
    private OrderMasterService orderMasterService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderMasterService.findList(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        System.out.println(orderDTOPage.getContent().get(0).getOrderStatusEnum().getMsg());
        return new ModelAndView("order/list", map);


    }

}
