package com.zh.dao.repository;

import com.zh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * StudentRepository
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/7/17:00
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findById(int id);
}
