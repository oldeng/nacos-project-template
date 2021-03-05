package com.account.controller;

import java.util.HashMap;
import java.util.Map;

import com.account.bean.User;
import com.account.service.BalanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/acc")
public class AccountController {
 
    final static Map<Integer, User> userMap = new HashMap() {{
            put(1, new User(1, "张三", null));
            put(2, new User(2, "李四", null));
            put(3, new User(3, "王五", null));
        }
    };

    @Autowired
    private BalanceService balanceService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@RequestParam Integer id) {
        if(id != null && userMap.containsKey(id)) {
            User user = userMap.get(id);
            user.setBalance(balanceService.getBalance(id));
            return user;
        }
        return new User(0, "", null);
    }
}