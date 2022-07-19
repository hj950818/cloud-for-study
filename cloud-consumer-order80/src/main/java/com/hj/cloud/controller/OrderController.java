package com.hj.cloud.controller;

import com.hj.cloud.commonResult.CommonResult;
import com.hj.cloud.entity.Payment;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

//单机版本
//    final String PAYMENT_URL="http://localhost:8001";
//    集群版
    final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    RestTemplate restTemplate;

    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        log.info("保存成功！");
        return commonResult;
    }

    @GetMapping("{id}/get")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/" + id + "/get", CommonResult.class);
        log.info("查询成功："+commonResult.getData());
       return commonResult;
    }

}
