package com.xmt.mybatis.mapper;

import com.xmt.mybatis.pojo.Dept;
import com.xmt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * @author xmttz
 * @create 2022/3/20 21:03
 * @description
 */
public interface DeptMapper {
    //通过分布查询查询员工以及员工所对应的部门信息:分两步
    //②通过did查询员工所对应的员工信息
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    //获取部门以及部门中所有的员工信息
    Dept getDeptAndEmp(@Param("did") Integer did);

    //通过分布查询查询部门以及部门中所有的员工信息
    //分布查询第一步：查询部门信息
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
