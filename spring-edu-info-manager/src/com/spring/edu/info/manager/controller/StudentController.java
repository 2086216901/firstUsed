package com.spring.edu.info.manager.controller;

import com.spring.edu.info.manager.domain.Student;
import com.spring.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private static StudentService studentService = new StudentService();
    private static Scanner sc = new Scanner(System.in);

    public  void start() {
        Scanner sc = new Scanner(System.in);
        SudentLoop:while (true){
            System.out.println("欢迎来到学生信息管理系统");
            System.out.println("请输入你的选择：1.添加学生 2.删除学生 3.修改学生 4.查看学生 5.退出");
            String choice = sc.next();
            switch (choice){
                case "1":
//                    System.out.println("添加");
                    addStudent();
                    break;

                case "2":
//                    System.out.println("删除");
                    deleteStudentById();
                    break;
                case "3":
//                    System.out.println("修改");
                    updateStudent();
                    break;
                case "4":
//                    System.out.println("查找");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("已退出学生管理系统");
                    break SudentLoop;

                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }

    }

    public static void updateStudent() {
        Student stus[] = studentService.findAllStudent();
        if (stus == null){
            System.out.println("查无信息，请添加后尝试");
            return;

        }
        String upadateId = inputStudentId();
        Student newstu = inputStudentInfo(upadateId);
        studentService.updateStudent(upadateId,newstu);
        System.out.println("修改成功");

    }

    public static Student inputStudentInfo(String id) {
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        String age = sc.next();
        System.out.println("请输入生日");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }

    public static String inputStudentId( ) {
        String id;
        while(true){
            System.out.println("请输入学生学号");
           id = sc.next();
            boolean exists = studentService.isExists(id);
            if (exists){
                break;
            }else {
                System.out.println("查无信息，请重新输入");
            }
        }
        return id;
    }

    public static void deleteStudentById() {
        Student stus[] = studentService.findAllStudent();
        if (stus == null){
            System.out.println("查无信息，请添加后尝试");
            return;

        }
        String delId = inputStudentId();
        studentService.deleteStudentById(delId);
        System.out.println("删除成功");


    }

    public  static void findAllStudent() {
        Student stus[] = studentService.findAllStudent();
        if (stus == null){
            System.out.println("查无信息，请添加后尝试");
            return;

        }
        System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu!=null)
            {
                System.out.println(stu.getId()+"\t"+stu.getName()+"\t\t"+stu.getAge()+"\t\t"+ stu.getBirthday());
            }
        }

    }

    public static void addStudent() {
        String id;
        while (true){
            System.out.println("请输入学号");
            id =sc.next();
            boolean flag = studentService.isExists(id);
            if(flag){
                System.out.println("学号已存在，请重新输入");

            }else {
                break;
            }
        }
        Student stu = inputStudentInfo(id);
        boolean result = StudentService.addStudent(stu);
        if (result){
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }

    }
}
