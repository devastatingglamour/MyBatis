package com.xmt.mybatis.mapper;

import com.xmt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * @author xmttzvd
 * @create 2022/3/24 15:53
 * @description
 */
public interface CacheMapper {
    //根据eid查询员工
    Employee getEmpByEid(Integer eid);
    //添加员工
    void insertEmp(Employee employee);
}
