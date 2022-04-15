package com.xmt.mybatis.mapper;

import com.xmt.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xmttz
 * @create 2022/3/17 16:16
 * @description
 */
public interface ParameterMapper {
    //查询所有的员工信息
    List<User> getAllUser();
    //根据用户名查询员工信息
    User getUserById(String username);
    //验证登录
    User checkLogin(String username,String password);
    //验证登录（参数为map）
    User checkLoginByMap(Map<String,Object> map);
    //添加用户信息
    int insertUser(User user);
    //验证登录（使用@Param）
    User checkLoginByParam(@Param("username")String username,@Param("password")String password);
}
