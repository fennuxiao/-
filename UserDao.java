package com.example.health.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.example.health.bean.user;

@Repository
public interface UserDao {
    public user getUserByMassage(@Param("username") String username, @Param("password") String password);
}
