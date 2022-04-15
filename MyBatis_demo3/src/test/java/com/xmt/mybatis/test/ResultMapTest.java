package com.xmt.mybatis.test;

import com.xmt.mybatis.mapper.DeptMapper;
import com.xmt.mybatis.mapper.EmployeeMapper;
import com.xmt.mybatis.pojo.Dept;
import com.xmt.mybatis.pojo.Employee;
import com.xmt.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author xmttz
 * @create 2022/3/21 18:28
 * @description
 */
public class ResultMapTest {
    /**
     * 解决字段名和属性名不一致的情况：
     * ①为字段名起别名，保持和属性名的一致
     * ②设置全局配置，将_自动映射为驼峰
     * <setting name="mapUnderscoreTocamlCase" value="true"/>
     * ③通过ResultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Employee">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     * </resultMap>
     *
     * 处理多对一的映射关系：
     * ①级联属性赋值
     * ②association实现
     * ③分布查询
     *
     * 处理一对多的映射关系：
     * ①collection
     * ②分步查询
     */

    //查询所有员工信息
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.getAllEmp();
        list.forEach(employee -> System.out.println(employee));
    }

    //根据eid查询员工信息以及所属部门
    @Test
    public void testGetAllEmpAndDept(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        System.out.println(mapper.getEmpAndDept(1));
    }

    //通过分步查询查询员工以及员工所对应的部门信息:分两步
    @Test
    public void testGetEmpAndDeptByStepOne(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmpAndDeptByStepOne(4);
        System.out.println(emp.getEmpName());
        System.out.println("***************");
        System.out.println(emp.getDept());
    }

    //获取部门以及部门中所有的员工信息
    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(2);
        System.out.println(dept);
    }

    //分布查询获取部门以及部门中所有的员工信息
    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept.getEmps());
    }
}
