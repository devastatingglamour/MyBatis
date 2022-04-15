package com.xmt.mybatis.test;

import com.xmt.mybatis.mapper.SelectMapper;
import com.xmt.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author xmttz
 * @create 2022/3/19 10:22
 * @description
 */
public class SelectMapperTest {

    /**
     * MyBatis的各种查询功能：
     * 1、若查询出的数据只有一条:
     * ①可以通过实体类对象接收
     * ②可以通过list集合接收
     * ③可以通过map集合接收
     * 2、若查询出的数据有多条：
     * ①可以通过实体类类型的list集合接收
     * ②可以通过map类型的list集合接收
     * ③可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
     * 注：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(6));
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(7));
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }
}
