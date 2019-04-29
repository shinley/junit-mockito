package com.shinley.biz;

import com.shinley.dao.MyUserDao;
import com.shinley.model.MyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
public class MyUserBizTest {

    @InjectMocks
    private MyUserBiz myUserBiz;

    @Mock
    private MqBiz mqBiz;

    @Mock
    private MyUserDao myUserDao;

    @Test
    public void testQueryById() {
        MyUser myUser = new MyUser();
        myUser.setId(1);
        myUser.setName("cxl");
        when(myUserDao.queryById(anyInt())).thenReturn(myUser);

        when(mqBiz.mqMsg()).thenReturn("word");

        myUser = myUserBiz.queryById(1);
        System.out.println(myUser.getMqMsg());
    }
}
