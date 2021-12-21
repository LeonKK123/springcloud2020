package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommentResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.annotation.Resource;
import javax.xml.stream.events.Comment;

/**
 * @author puming
 * @date2021/11/17 2021/11/17
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "/payment/create")
    public CommentResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        if(result > 0)
        {
            return new CommentResult(200,"插入数据库成功,serverPort: ",result);
        }else{
            return new CommentResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping(value = "/")
    public String  test01(){
        return "success";
    }

    @RequestMapping(value = "/{id}" )
    public CommentResult<Payment> getPaymentById(@PathVariable("id") long id)
    {
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null)
        {
            return new CommentResult(200,"查询成功,serverPort:  ",payment);
        }else{
            return new CommentResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }


}
