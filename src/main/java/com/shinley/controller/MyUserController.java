package com.shinley.controller;

import com.shinley.biz.MyUserBiz;
import com.shinley.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myuser")
public class MyUserController {

    @Autowired
    private MyUserBiz myUserBiz;

    @GetMapping("/queryById")
    public MyUser queryById(int id) {
        return myUserBiz.queryById(id);
    }
}
