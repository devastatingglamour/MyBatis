package com.xmt.mybatis.test;

import com.xmt.mybatis.mapper.SQLMapper;
import com.xmt.mybatis.pojo.User;
import com.xmt.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author xmttz
 * @create 2022/3/20 9:51
 * @description
 */
public class SQLMapperTest {
    @Test
    public void testGetUserBylike(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.getUserByLike("三"));
    }

    @Test
    public void testDeleteMoreById(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.deleteMoreById("4,5,6"));
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.getUserByTableName("t_user"));
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user=new User(null,"王五","456",26,"女","456@163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
