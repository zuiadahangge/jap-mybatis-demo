package com.zh.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/7/16:59
 */
@Table(name = "student")
@Entity
@Data
@Accessors(chain = true)
@ToString
public class Student {
    @Id
    private Integer id;
    private String name;
}
