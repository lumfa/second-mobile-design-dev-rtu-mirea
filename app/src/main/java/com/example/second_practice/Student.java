package com.example.second_practice;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String groupId;
    private Integer age;
    private Integer grade;

    public Student(String name, String groupId, Integer age, Integer grade) {
        this.name = name;
        this.groupId = groupId;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getgroupId() {
        return groupId;
    }
}
