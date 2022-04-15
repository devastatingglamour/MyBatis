package com.xmt.mybatis.test;

import com.xmt.mybatis.mapper.CacheMapper;
import com.xmt.mybatis.mapper.DynamicSQLMapper;
import com.xmt.mybatis.pojo.Employee;
import com.xmt.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author xmttz
 * @create 2022/3/24 16:00
 * @description
 */
public class CacheMapperTest {
    @Test
    public void testOneCache(){
        SqlSession sqlSession1= SqlSessionUtils.getSqlSession();
        CacheMapper mapper1=sqlSession1.getMapper(CacheMapper.class);
        Employee emp1 = mapper1.getEmpByEid(2);
        System.out.println(emp1);
        //mapper1.insertEmp(new Employee(null,"abc",23,"男","123@qq.com"));
        sqlSession1.clearCache();
        Employee emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);
    }

    @Test
    public void testTwoCache(){
        try {
            InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(2));
            sqlSession1.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(3));
            sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
