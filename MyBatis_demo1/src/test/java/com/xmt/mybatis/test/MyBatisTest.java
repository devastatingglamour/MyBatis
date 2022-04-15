package com.xmt.mybatis.test;

import com.xmt.mybatis.mapper.UserMapper;
import com.xmt.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xmttz
 * @create 2022/3/15 16:16
 * @description
 */
public class MyBatisTest {
    /**
     * SqlSession默认不自动提交事务，若要自动提交事务
     * 可以使用SqlSessionFactory.openSession(true)
     * @throws IOException
     */
    @Test
    public void testCURD() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取SqlsessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取Sqlsession,并自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //测试功能
        //int result1 = mapper.insertUser();
        //int result2 = mapper.updateUser();
        //int result3 = mapper.deleteUser();
        //User user=mapper.selectUserById();
        //System.out.println(user);
        List<User> users = mapper.selectAllUser();
        users.forEach(user -> System.out.println(user));
    }

}
