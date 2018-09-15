package com.zh.service.impl;

import com.zh.dao.interfaces.StudentDao;
import com.zh.dao.repository.StudentRepository;
import com.zh.entity.Student;
import com.zh.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * StudentServiceImpl
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/7/17:07
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = Logger.getLogger(StudentServiceImpl.class);

    @Resource
    private StudentRepository studentRepository;


    @Resource
    private StudentDao studentDao;

    @Override
    public Student jpa_findById(int id) {
        return studentRepository.findById(id);
    }


    @Override
    public void jpa_insert(Student student) {
        log.info("jap待插入--"+student);
        studentRepository.save(student);
        log.info("jap已插入--"+student);
    }

    @Override
    public Student m_findById(int id) {
        return studentDao.findOne(id);
    }

    @Override
    public void m_insert(Student student) {
        log.info("mybatis待插入--"+student);
        studentDao.insertOne(student);
        log.info("mybatis已插入--"+student);
    }


    @Transactional
    @Override
    public void all_insert(Student student) {

        //第一组插入
        log.info("jap待插入--"+student);
        studentRepository.save(student);
        log.info("jap已插入--"+student);

        student.setId(student.getId()+1);
        student.setName(student.getName()+1);
        log.info("mybatis待插入--"+student);
        studentDao.insertOne(student);
        log.info("mybatis已插入--"+student);

        //测试事务回滚
        if (true)throw new RuntimeException();
        //第er组插入
        log.info("jap待插入--"+student);
        studentRepository.save(student);
        log.info("jap已插入--"+student);

        student.setId(student.getId()+1);
        student.setName(student.getName()+1);
        log.info("mybatis待插入--"+student);
        studentDao.insertOne(student);
        log.info("mybatis已插入--"+student);
    }
}
