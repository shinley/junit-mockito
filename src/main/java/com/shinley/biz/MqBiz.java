package com.shinley.biz;

import org.springframework.stereotype.Component;

@Component
public class MqBiz {
    public String mqMsg() {
        return "hello";
    }
}
