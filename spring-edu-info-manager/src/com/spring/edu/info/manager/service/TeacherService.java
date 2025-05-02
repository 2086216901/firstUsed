package com.spring.edu.info.manager.service;

import com.spring.edu.info.manager.dao.TeacherDao;
import com.spring.edu.info.manager.domain.Teacher;

public class TeacherService {
    static TeacherDao teacherDao = new TeacherDao();

    public static boolean addTeacher(Teacher t) {
        boolean result = teacherDao.addTeacher(t);
        return result;
    }

    public  boolean isExists(String id) {
        Teacher[] teachers = teacherDao.findAllTeacher();
        boolean exists = false;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null && t.getId().equals(id)) {
                exists = true;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeacher() {
        Teacher[] allTeacher = teacherDao.findAllTeacher();
        boolean flag = false;
        for (int i = 0; i < allTeacher.length; i++) {
            Teacher t = allTeacher[i];
            if (t!=null){
                flag = true;
            }
        }
        if (flag){
            return allTeacher;
        }else {
            return null;
        }
    }

    public boolean deleteTeacher(String delId) {
        boolean reselt = teacherDao.deleteTeacher(delId);
        return reselt;
    }

    public boolean updateTeacher(String updateId, Teacher newT) {
        return teacherDao.updateTeacher(updateId,newT);
    }
}
