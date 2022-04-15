package com.xmt.mybatis.mapper;

import com.xmt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xmttz
 * @create 2022/3/23 20:50
 * @description
 */
public interface DynamicSQLMapper {
    //实现多条件查询1
    List<Employee> getEmpByConditionOne(Employee employee);
    //实现多条件查询2
    List<Employee> getEmpByConditionTwo(Employee employee);
    //实现多条件查询3
    List<Employee> getEmpByConditionThree(Employee employee);
    //测试choose、when、otherwise
    List<Employee> getEmpByChoose(Employee employee);
    //通过数组实现批量删除
    int deleteMoreByArray(@Param("eids") Integer[] eids);
    //通过list集合实现批量添加
    int insertMoreByList(@Param("emps") List<Employee> emps);
}
