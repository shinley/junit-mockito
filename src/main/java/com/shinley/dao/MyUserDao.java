package com.shinley.dao;

import com.shinley.model.MyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyUserDao {
    MyUser queryById(int id);
}
