package com.zh.controller;

import com.zh.entity.Student;
import com.zh.service.StudentService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * StudentController
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/7/17:02
 *
 */
@RestController
public class StudentController {
    @Resource
    private StudentService studentService;


    ///////////////////////////////////////////////////////////jpa

    /**
     * jpa 查询
     * @param id
     * @return
     */
    @GetMapping("jpa/student/{id}")
    public Student jpa_findById(@PathVariable int id){
        return studentService.jpa_findById(id);
    }


    /**
     * jpa 插入
     * @param student
     * @return
     */
    @PostMapping("jpa/insert")
    public ModelMap jap_insert(@RequestBody Student student){
        studentService.jpa_insert(student);
        return getSuccess();
    }

///////////////////////////////////////////////////////////mybatis

    /**
     * mybatis 查询
     * @param id
     * @return
     */
    @GetMapping("m/student/{id}")
    public Student m_findById(@PathVariable int id){
        return studentService.m_findById(id);
    }

    /**
     * mybatis 插入
     * @param student
     * @return
     */
    @PostMapping("m/insert")
    public ModelMap m_insert(@RequestBody Student student){
        studentService.m_insert(student);
        return getSuccess();
    }


    ///////////////////////////////////////////两个同时用，事务操作,是否回滚jpa和mybatis被同一个事务管理


    /**
     * 两个同时用，事务操作,是否回滚jpa和mybatis被同一个事务管理
     * @param student
     * @return
     */
    @PostMapping("all/insert")
    public ModelMap all_insert(@RequestBody Student student){
        studentService.all_insert(student);
        return getSuccess();
    }


    private ModelMap getSuccess(){
        return new ModelMap(){{
            put("code",200);
            put("msg",true);
        }};
    }

}
