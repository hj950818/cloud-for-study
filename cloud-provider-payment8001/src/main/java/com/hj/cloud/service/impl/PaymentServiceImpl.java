package com.hj.cloud.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hj.cloud.dao.PaymentDao;
import com.hj.cloud.entity.Payment;
import com.hj.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao dao;

    @Override
    public int create(Payment payment) {
        return dao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return dao.getPaymentById(id);
    }
}
