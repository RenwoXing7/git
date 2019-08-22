package com.newer.springbootmybaties0809.service.Impl;

import com.newer.springbootmybaties0809.domin.Dept;
import com.newer.springbootmybaties0809.domin.Emp;
import com.newer.springbootmybaties0809.mapper.IEmpMapper;
import com.newer.springbootmybaties0809.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empService")
public class IEmpServiceImpl implements IEmpService {

    @Autowired
    private IEmpMapper empMapper;

    @Override
    public List<Emp> query() {
        return empMapper.query();
    }

    @Override
    public Emp queryById(Integer empno) {
        return empMapper.queryById(empno);
    }

    @Override
    public int add(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int update(Emp emp) {
        return empMapper.update(emp);
    }

    @Override
    public int delete(Integer empno) {
        return empMapper.delete(empno);
    }

    @Override
    public List<Dept> queryDept() {
        return empMapper.queryDept();
    }
}
