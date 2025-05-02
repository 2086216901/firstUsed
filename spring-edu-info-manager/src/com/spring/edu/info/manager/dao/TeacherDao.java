package com.spring.edu.info.manager.dao;

import com.spring.edu.info.manager.domain.Teacher;

public class TeacherDao {
    Teacher[] teachers = new Teacher[5];

    public boolean addTeacher(Teacher t) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher==null){
                index = i;
                break;
            }

        }
        if (index !=-1){
            teachers[index]=t;
            return true;
        }
        else {
            return false;
        }
    }

    public Teacher[] findAllTeacher() {
        return teachers;
    }

    public boolean deleteTeacher(String delId) {
        int index = getIndex(delId);
        teachers[index]=null;
        return true;
    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t!=null&&t.getId().equals(id)){
                index = i;
            }
        }
        return index;
    }

    public boolean updateTeacher(String updateId, Teacher newT) {

        int index = getIndex(updateId);
        teachers[index]=newT;
        return true;
    }
}
