package com.javasea.account.controller;

import com.javasea.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/debit/{userId}/{money}")
    public Boolean debit(@PathVariable("userId") String userId, @PathVariable("money") Integer money) {
        accountService.debit(userId, money);
        return true;
    }
}
