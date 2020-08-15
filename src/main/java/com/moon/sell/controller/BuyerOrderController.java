package com.moon.sell.controller;

import com.moon.sell.VO.ResultVO;
import com.moon.sell.converter.OrderForm2OrderDTOConvert;
import com.moon.sell.dto.OrderDTO;
import com.moon.sell.enums.ResultEnum;
import com.moon.sell.exception.SellException;
import com.moon.sell.form.OrderForm;
import com.moon.sell.service.BuyerService;
import com.moon.sell.service.OrderMasterService;
import com.moon.sell.service.impl.BuyerServiceImpl;
import com.moon.sell.service.impl.OrderMasterServiceImpl;
import com.moon.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.MessageWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * @author lhw
 * @date 2020/8/15
 */
@Slf4j
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

     @Autowired
     private OrderMasterService orderMasterService;

     @Autowired
     private BuyerService buyerService;

     //  创建订单
     @PostMapping("/create")
     public ResultVO<Map<String,String >> create(@Valid OrderForm orderForm, BindingResult bindingResult){
          if(bindingResult.hasErrors()){
               log.error("【创建订单】参数不正确， orderForm={}",orderForm);
                throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
          }

          OrderDTO orderDTO = OrderForm2OrderDTOConvert.convert(orderForm);
          if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
               log.error("【创建订单】购物车不能为空");
               throw new SellException(ResultEnum.CART_EMPTY);
          }
          OrderDTO orderDTO1 = orderMasterService.create(orderDTO);
          Map<String,String> map = new HashMap<>();
          map.put("order_id",orderDTO1.getOrderId());

          return ResultVOUtil.success(map);
     }


     // 订单列表
     @GetMapping("/list")
     public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                          @RequestParam(value = "page",defaultValue = "0") Integer page,
                                          @RequestParam(value = "size",defaultValue = "10") Integer size
                                        ){
          if(StringUtils.isEmpty(openid)){
               log.error("【查询订单列表】openid 为空");
               throw new SellException(ResultEnum.PARAM_ERROR);
          }
          PageRequest pageRequest = PageRequest.of(page,size);
          List<OrderDTO> orderDTOList = orderMasterService.findList(openid, pageRequest).getContent();

          //  Date ---> long

          return ResultVOUtil.success(orderDTOList);

     }

     // 订单详情
     @GetMapping("/detail")
     public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                      @RequestParam("orderId") String orderId){
//         不安全的做法
//          OrderDTO orderDTO = orderMasterService.findOne(orderId);

          // 判断传出来的openid 和 数据库中的openid是不是一样
          OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
          return ResultVOUtil.success(orderDTO);

     }

     // 取消订单
     @PostMapping("/cancel")
     public ResultVO cancel(@RequestParam("openid") String openid,
                            @RequestParam("orderId") String orderId){
//         不安全的做法
//          OrderDTO orderDTO = orderMasterService.findOne(orderId);

          buyerService.cancelOrder(openid, orderId);
          return ResultVOUtil.success();
     }


}
