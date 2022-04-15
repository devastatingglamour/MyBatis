package com.xmt.mybatis.mapper;

import com.xmt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xmttz
 * @create 2022/3/20 21:03
 * @description
*/
public interface EmployeeMapper {
    //查询所有的员工信息
    List<Employee> getAllEmp();
    //查询员工以及员工所对应的部门信息
    Employee getEmpAndDept(@Param("eid") Integer eid);
    //通过分布查询查询员工以及员工所对应的部门信息:分两步
    //①查询员工信息
    Employee getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    //通过分布查询查询部门信息以及部门中所有的员工:分两步
    //②根据did查询该部门所有员工信息
    List<Employee> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
