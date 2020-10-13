package com.kgc.controller;

import com.kgc.remote.ProductRemote;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @author lbk
 * @date 2020/9/1 15:44
 **/
public class OrderController {

    @Resource
    private ProductRemote productRemote;

    @GetMapping("/getOrderDetail")
    public Object getOrderDetail() {
        Integer productId = 10066;
        String product = productRemote.getProductById(productId);
        System.out.println("服务消费者》获取到远程服务提供的商品信息");
        return product;
    }
}
