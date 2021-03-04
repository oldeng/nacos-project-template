package com.payment.controller;

import java.util.HashMap;
import java.util.Map;

import com.payment.bean.Balance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pay")
@RefreshScope
public class PaymentController {
 
    @Value("${sleep:0}")
    private int sleep;
 
    final static Map<Integer, Balance> balanceMap = new HashMap() {{
            put(1, new Balance(1, 10, 1000));
            put(2, new Balance(2, 0, 10000));
            put(3, new Balance(3, 100, 0));
        }
    };
 
    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    @ResponseBody
    public Balance getBalance(Integer id) {
        System.out.println("request: /pay/balance?id=" + id + ", sleep: " + sleep);
        Balance balance = new Balance(0, 0, 0);
        if(sleep > 0) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(id != null && balanceMap.containsKey(id)) {
            return balanceMap.get(id);
        }
        return balance;
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}