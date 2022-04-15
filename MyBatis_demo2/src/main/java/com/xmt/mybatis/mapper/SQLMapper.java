package com.xmt.mybatis.mapper;

import com.xmt.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xmttz
 * @create 2022/3/20 9:49
 * @description
 */
public interface SQLMapper {
    //根据用户名模糊查询用户信息
    List<User> getUserByLike(@Param("username") String username);
    //根据id批量删除
    int deleteMoreById(@Param("ids") String ids);
    //查询指定表中的数据
    List<User> getUserByTableName(@Param("tableName") String tablename);
    //添加用户信息
    void insertUser(User user);
}
