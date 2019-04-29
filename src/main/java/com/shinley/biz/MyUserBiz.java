package com.shinley.biz;

import com.shinley.dao.MyUserDao;
import com.shinley.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyUserBiz {

    @Autowired
    private MyUserDao myUserDao;

    @Autowired
    private MqBiz mqBiz;

    public MyUser queryById(int id) {
        MyUser myUser = myUserDao.queryById(id);
        myUser.setMqMsg(mqBiz.mqMsg());
        return myUser;
    }
}
