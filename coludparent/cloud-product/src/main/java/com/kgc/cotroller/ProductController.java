package com.kgc.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lbk
 * @date 2020/8/28 17:09
 **/
@RestController
public class ProductController {
    @GetMapping("getProduct")
    public String getProduct(Integer productId){
        System.out.println("《微服务提供者》根据ID查询商品："+productId);
        return "这是你要的商品"+productId;
    }
}
