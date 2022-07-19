package com.hj.cloud.service;

import com.hj.cloud.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
