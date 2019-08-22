package com.newer.springbootmybaties0809.mapper;


import com.newer.springbootmybaties0809.domin.Dept;
import com.newer.springbootmybaties0809.domin.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("empMapper")
public interface IEmpMapper {

    /**
     * 查询所有员工信息
     * @return
     */
    @Select("SELECT a.EMPNO,a.ENAME,a.JOB,a.SAL,a.HIREDATE,b.DEPTNO,b.DNAME,b.LOC FROM T_EMP a LEFT JOIN T_DEPT b ON a.DEPTNO=b.DEPTNO")
    @Results({
            @Result(property = "empno",column = "EMPNO"),
            @Result(property = "ename",column = "ENAME"),
            @Result(property = "job",column = "JOB"),
            @Result(property = "sal",column = "SAL"),
            @Result(property = "hiredate",column = "HIREDATE"),
            @Result(property = "dept.deptno",column = "DEPTNO"),
            @Result(property = "dept.dname",column = "DNAME"),
            @Result(property = "dept.loc",column = "LOC")
    })
    public List<Emp> query();

    /**
     * 查询单个员工信息
     * @param empno
     * @return
     */
    @Select("SELECT a.EMPNO,a.ENAME,a.JOB,a.SAL,a.HIREDATE,b.DEPTNO,b.DNAME,b.LOC FROM T_EMP a LEFT JOIN T_DEPT b ON a.DEPTNO=b.DEPTNO WHERE a.EMPNO=#{empno}")
    @Results({
            @Result(property = "empno",column = "EMPNO"),
            @Result(property = "ename",column = "ENAME"),
            @Result(property = "job",column = "JOB"),
            @Result(property = "sal",column = "SAL"),
            @Result(property = "hiredate",column = "HIREDATE"),
            @Result(property = "dept.deptno",column = "DEPTNO"),
            @Result(property = "dept.dname",column = "DNAME"),
            @Result(property = "dept.loc",column = "LOC")
    })
    public Emp queryById(Integer empno);

    /**
     * 插入员工信息
     * @param emp
     * @return
     */
    @Insert("INSERT INTO T_EMP(EMPNO,ENAME,JOB,HIREDATE,SAL,DEPTNO) VALUES(#{empno},#{ename},#{job},#{hiredate},#{sal},#{dept.deptno})")
    public int insert(Emp emp);

    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    @Update("UPDATE T_EMP SET ENAME=#{ename},JOB=#{job},SAL=#{sal},HIREDATE=#{hiredate},DEPTNO=#{dept.deptno} WHERE EMPNO=#{empno}")
    public int update(Emp emp);

    /**
     * 根据员工编号删除员工信息
     * @param empno
     * @return
     */
    @Delete("DELETE FROM T_EMP WHERE EMPNO=#{empno}")
    public int delete(Integer empno);

    /**
     * 获得所有的部门信息
     * @return
     */
    @Select("SELECT DEPTNO,DNAME,LOC FROM T_DEPT ORDER BY DEPTNO ASC")
    public List<Dept> queryDept();

}
