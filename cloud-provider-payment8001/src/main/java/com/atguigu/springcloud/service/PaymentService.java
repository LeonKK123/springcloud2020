package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author puming
 * @date2021/11/17 2021/11/17
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
