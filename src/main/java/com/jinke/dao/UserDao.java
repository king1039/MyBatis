package com.jinke.dao;

import com.jinke.domain.User;
import com.jinke.mybatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> findAll();
}
