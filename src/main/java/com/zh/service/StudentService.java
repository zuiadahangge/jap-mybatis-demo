package com.zh.service;


import com.zh.entity.Student;

/**
 * StudentService
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/7/17:06
 */
public interface StudentService {
    Student jpa_findById(int id);

    void jpa_insert(Student student);

    Student m_findById(int id);

    void m_insert(Student student);

    void all_insert(Student student);
}
