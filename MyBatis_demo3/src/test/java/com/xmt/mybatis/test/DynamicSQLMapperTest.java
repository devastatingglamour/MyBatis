package com.xmt.mybatis.test;

import com.xmt.mybatis.mapper.DynamicSQLMapper;
import com.xmt.mybatis.pojo.Employee;
import com.xmt.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xmttz
 * @create 2022/3/23 21:09
 * @description
 */
public class DynamicSQLMapperTest {
    /**
     * 动态SQL:
     * 1、if:根据标签中test属性所对应的表达式决定标签的内容是否需要拼接到SQL中
     * 2、where:当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
     *          当where标签中没有内容时，此时where标签没有任何效果
     *    注意：where标签不能将其中内容后面多余的and或or去掉
     * 3、trim:
     * 若标签中有内容时：
     * prefix/suffix:将trim标签中内容前面或后面添加指定内容
     * suffixOverrides/prefixOverrides:将trim标签中内容前面或后面去掉指定内容
     * 若标签中没有内容时，trim标签也没有任何效果
     * 4、choose、when、otherwise相当于if...else if...else
     * 5、foreach
     * collection:设置需要循环的数组或集合
     * item:表示数组或集合中的每一个数据
     * separator:循环体之间的分隔符
     * open:foreach标签所循环的所有内容的开始符
     * close:foreach标签所循环的所有内容的结束符
     * 6、sql标签
     * 设置SQL片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用SQL片段：<include refid="empColumns"></include>
     */
    @Test
    public void testGetEmpByConditionOne(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        List<Employee> list = mapper.getEmpByConditionOne(new Employee(null, "张三", 22, "男", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByConditionTwo(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        List<Employee> list = mapper.getEmpByConditionTwo(new Employee(null, "张三", 22, "男", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByConditionThree(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        List<Employee> list = mapper.getEmpByConditionThree(new Employee(null, "", 22, "null", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        List<Employee> list = mapper.getEmpByChoose(new Employee(null, "", null, "男", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testdeleteMoreByArray(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(result);
    }

    @Test
    public void testinsertMoreByList(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        Employee employee1=new Employee(null,"a1",1,"男","111@qq.com");
        Employee employee2=new Employee(null,"a2",2,"男","222@qq.com");
        Employee employee3=new Employee(null,"a3",3,"男","333@qq.com");
        List<Employee> list = Arrays.asList(employee1, employee2, employee3);
        System.out.println(mapper.insertMoreByList(list));
    }
}
