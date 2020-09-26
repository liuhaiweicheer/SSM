package com.moon.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *   charies  抓包工具
 *
 *   分布式系统下的 Session ：
 *
 *     什么是分布式： 旨在支持应用程序和服务的开发，可以利用物理架构，由多个自治的处理元素， 不共享物理内存， 但通过网络发送消息合作
 *      1、 分布式系统    2、集群    3、分布式计算(分布式计算)
 *
 *      广义的Session----控制回话的机制（sessionId   token）
 *              服务器（生成 JsessionId 设置带HTTP头中发送给 客户端）
 *      分布式系统下怎么处理 用户的session问题   （ipHash 解决过多用户访问的一个方式）
 *
 *    解决方法：  用一个服务器专门保存用户的session，当其他服务需要session的时候就去这个服务器要。实现方式有 Redis集群，主从复制
 */


@MapperScan(basePackages = "com.moon.sell.dataObject.mapper")
@SpringBootApplication
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }

}
