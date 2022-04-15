package com.xmt.mybatis.mapper;

import com.xmt.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xmttz
 * @create 2022/3/19 10:10
 * @description
 */
public interface SelectMapper {
    //根据id查询用户信息
    List<User> getUserById(@Param("id") Integer id);
    //查询所有的用户信息
    List<User> getAllUser();
    //查询用户信息的总记录数
    Integer getCount();
    //根据id查询用户信息为一个map集合
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
    //查询所有用户信息为map集合
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}
