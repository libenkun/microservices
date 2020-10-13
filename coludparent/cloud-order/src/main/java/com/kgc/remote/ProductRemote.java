package com.kgc.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lbk
 * @date 2020/9/1 15:58
 **/
@FeignClient(name = "client-product")
public interface ProductRemote {
    @GetMapping("/getProductById")
    String getProductById(@RequestParam Integer productId);
}
