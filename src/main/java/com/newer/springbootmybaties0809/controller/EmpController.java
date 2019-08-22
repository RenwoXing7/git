package com.newer.springbootmybaties0809.controller;


import com.newer.springbootmybaties0809.domin.Dept;
import com.newer.springbootmybaties0809.domin.Emp;
import com.newer.springbootmybaties0809.service.IEmpService;
import org.apache.ibatis.annotations.Update;
import org.mybatis.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class EmpController {

    @Resource(name = "empService")
    private IEmpService empService;

    private static final org.mybatis.logging.Logger log = LoggerFactory.getLogger(EmpController.class);

    /**
     * 得到所有的员工信息
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> query() {
        List<Emp> emps = empService.query();
        ResponseEntity<List<Emp>> res = new ResponseEntity<List<Emp>>(emps, HttpStatus.OK);
        return res;
    }

    /**
     * 查询单个员工信息
     *
     * @param empno
     * @return
     */
    @GetMapping("/emp/{empnox}")
    public ResponseEntity<?> query(@PathVariable("empnox") Integer empno) {
        Emp emp = empService.queryById(empno);
        return new ResponseEntity<Emp>(emp, HttpStatus.OK);
    }

    /**
     * 完成删除
     *
     * @param empno
     * @return
     */
    @DeleteMapping("/emp/{empnox}")
    public ResponseEntity<?> delete(@PathVariable("empnox") Integer empno) {
        Integer i = empService.delete(empno);
        return new ResponseEntity<Integer>(i, HttpStatus.OK);
    }

    /**
     * 新增
     *
     * @param emp
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Emp emp) {
        Integer i = empService.add(emp);
        return new ResponseEntity<Integer>(i, HttpStatus.OK);
    }

    /**
     * 修改
     *
     * @param emp
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Emp emp) {
        Integer i = empService.update(emp);
        return new ResponseEntity<Integer>(i, HttpStatus.OK);
    }

    /**
     * 查询部门
     * @return
     */
    @GetMapping("/dept")
    public ResponseEntity<?> queryDept(){
        List<Dept> depts= empService.queryDept();
        return new ResponseEntity<List<Dept>>(depts,HttpStatus.OK);
    }

}
