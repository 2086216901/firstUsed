package com.spring.edu.info.manager.service;

import com.spring.edu.info.manager.dao.StudentDao;
import com.spring.edu.info.manager.domain.Student;

public class StudentService {
    private static StudentDao studentDao =new StudentDao();

    public static boolean addStudent(Student stu) {

        return studentDao.addStudent(stu);
    }

    public boolean isExists(String id) {
        Student[] stus = studentDao.findAllStudent();
        boolean exists = false;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student!=null&&student.getId().equals(id)){
                exists = true;
            }

        }
        return exists;
    }

    public Student[] findAllStudent() {
        Student[] allStudent = studentDao.findAllStudent();
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if (stu!=null){
                flag = true;
                break;

            }
        }
        if (flag){
            return allStudent;

        }else {
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String upadateId, Student newstu) {
        studentDao.updateStudent(upadateId,newstu);
    }
}
