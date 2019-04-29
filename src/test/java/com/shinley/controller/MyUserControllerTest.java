package com.shinley.controller;

import com.shinley.BaseTest;
import com.shinley.biz.MqBiz;
import com.shinley.biz.MyUserBiz;
import com.shinley.model.MyUser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class MyUserControllerTest extends BaseTest {

    @InjectMocks
    private MyUserController myUserController;

    @Mock
    private MyUserBiz myUserBiz;

    @Mock
    private MqBiz mqBiz;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(myUserController).build();
    }

    @Test
    public void testQueryById() throws Exception {
        MyUser myUser = new MyUser();
        myUser.setId(2);
        myUser.setName("cxlhaha");
        myUser.setMqMsg("haha");

        when(myUserBiz.queryById(anyInt())).thenReturn(myUser);
        when(mqBiz.mqMsg()).thenReturn("word");

        mockMvc.perform(get("/myuser/queryById") // //调用接口
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("id", "1")//传入添加的用户参数 
                .accept(MediaType.APPLICATION_JSON_UTF8))  //接收的类型
                .andExpect(MockMvcResultMatchers.handler().handlerType(MyUserController.class))
                .andExpect(status().isOk())   //判断接收到的状态是否是200
                .andDo(print())//打印内容
                .andReturn();
    }
}
