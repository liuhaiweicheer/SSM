package com.moon.sell.service.impl;

import com.moon.sell.dto.OrderDTO;
import com.moon.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author lhw
 * @date 2020/8/25
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId("dasdasdasd");
        wxMpTemplateMessage.setToUser("dasdasdas");
        List<WxMpTemplateData> list = Arrays.asList(
                new WxMpTemplateData("first","记得收货"),
                new WxMpTemplateData("","")
        );
        wxMpTemplateMessage.setData(list);

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        } catch (WxErrorException e) {
            log.error("模板信息发送失败");
            e.printStackTrace();
        }
    }
}
