package com.zh.dao.interfaces;


import com.zh.entity.Student;

/**
 * StudentDao
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/10/10:06
 */
public interface StudentDao {
    Student findOne(int id);

    void insertOne(Student student);
}
