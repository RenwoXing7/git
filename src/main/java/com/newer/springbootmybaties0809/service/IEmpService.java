package com.newer.springbootmybaties0809.service;

import com.newer.springbootmybaties0809.domin.Dept;
import com.newer.springbootmybaties0809.domin.Emp;

import java.util.List;

public interface IEmpService {

    /**
     * 查询所有员工信息
     *
     * @return
     */
    public List<Emp> query();

    /**
     * 查询单个员工信息
     *
     * @param empno
     * @return
     */
    public Emp queryById(Integer empno);

    /**
     * 插入员工信息
     *
     * @param emp
     * @return
     */
    public int add(Emp emp);

    /**
     * 修改员工信息
     *
     * @param emp
     * @return
     */
    public int update(Emp emp);

    /**
     * 根据员工编号删除员工信息
     *
     * @param empno
     * @return
     */
    public int delete(Integer empno);

    /**
     * 获得所有的部门信息
     *
     * @return
     */
    public List<Dept> queryDept();
}
