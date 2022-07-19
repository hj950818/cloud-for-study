package com.hj.cloud.controller;

import com.hj.cloud.commonResult.CommonResult;
import com.hj.cloud.entity.Payment;
import com.hj.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String ServerPort;

    @Resource
    PaymentService service;

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment){
        int result = service.create(payment);
        if (result>0){
            log.info("保存成功:"+result);
            return new CommonResult(200,"保存成功,ServerPort:"+ServerPort,result);
        }else {
            return new CommonResult<>(500,"保存失败");
        }
    }

    @GetMapping("/{id}/get")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = service.getPaymentById(id);

        if (ObjectUtils.isEmpty(paymentById)){
            return new CommonResult<>(406,"数据不存在");
        }else {
            log.info("查询成功："+ paymentById.toString());
            return new CommonResult(200,"查询成功,ServerPort:"+ServerPort,paymentById);
        }
    }


}
