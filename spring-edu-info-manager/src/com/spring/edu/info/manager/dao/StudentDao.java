package com.spring.edu.info.manager.dao;

import com.spring.edu.info.manager.domain.Student;

public class StudentDao {
    private  static Student[] stus = new Student[5];

    public boolean addStudent(Student stu) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            if (stus[i]==null) {
                index = i;
                break;
            }
        }
        if (index==-1){
            return false;
        }else {
            stus[index]=stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delId) {
        int index = getIndex(delId);
        stus[index]=null;

    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            if (stus[i]!=null&&stus[i].getId().equals(id)){
                index = i;

            }
        }
        return index;
    }

    public void updateStudent(String upadateId, Student newstu) {
        int index = getIndex(upadateId);
        stus[index]=newstu;
    }
}
