package com.spring.edu.info.manager.controller;

import com.spring.edu.info.manager.domain.Teacher;
import com.spring.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherService = new TeacherService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        teacherLoop:
        while (true) {
            System.out.println("欢迎来到老师信息管理系统");
            System.out.println("请输入你的选择：1.添加老师 2.删除老师 3.修改老师 4.查看老师 5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
//                    System.out.println("添加老师");
                    addTeacher();

                    break;
                case "2":
//                    System.out.println("删除老师");
                    deleteTeacher();
                    break;
                case "3":
//                    System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
//                    System.out.println("查找老师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("已退出老师管理系统");
                    break teacherLoop;
            }

        }


    }

    public void updateTeacher() {
        Teacher[] allTeacher = teacherService.findAllTeacher();
        if (allTeacher == null) {
            System.out.println("查无信息，请添加后尝试");
            return;
        }
        String updateId = inputTeacherId();

        Teacher newT = inputTeacherInfo(updateId);
        teacherService.updateTeacher(updateId,newT);
        System.out.println("修改成功");

    }

    public Teacher inputTeacherInfo(String Id) {
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        String age = sc.next();
        System.out.println("请输入生日");
        String birthday = sc.next();
        Teacher newT = new Teacher(Id,name,age,birthday);
        return newT;
    }

    public void deleteTeacher() {
        Teacher[] allTeacher = teacherService.findAllTeacher();
        if (allTeacher == null) {
            System.out.println("查无信息，请添加后尝试");
            return;
        }
        String delId = inputTeacherId();
        teacherService.deleteTeacher(delId);
        System.out.println("删除成功");


    }

    public String inputTeacherId() {
        String Id;
        while (true) {
            System.out.println("请输入工号");
            Id = sc.next();
            boolean exists = teacherService.isExists(Id);
            if (!exists) {
                System.out.println("查无信息,请重新输入");
            } else {
                break;

            }



        }
        return Id;
    }

    public void findAllTeacher() {
        Teacher[] teacher = teacherService.findAllTeacher();
        if (teacher == null) {
            System.out.println("查无信息，请添加后尝试");
            return;
        }
        System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t生日");
        for (int i = 0; i < teacher.length; i++) {
            Teacher t = teacher[i];
            if (t != null) {
                System.out.println(t.getId() + "\t" + t.getName() + "\t\t" + t.getAge() + "\t\t" + t.getBirthday());
            }
        }

    }

    public void addTeacher() {
        String id;
        while (true) {
            System.out.println("请输入老师工号");
            id = sc.next();
            boolean result = teacherService.isExists(id);
            if (result) {
                System.out.println("工号已存在，请重新输入");
            } else {
                break;
            }
        }

        Teacher t = inputTeacherInfo(id);
        boolean flag = TeacherService.addTeacher(t);
        if (flag) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }


    }
}
