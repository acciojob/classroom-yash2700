package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository sr;

    void addStudentService(Student student){
        sr.addStudentToDb(student);
    }

    void addteacherService(Teacher teacher){
        sr.addTeacherToDb(teacher);
    }

    void addStudentTeacherPairService(String studentName,String teacherName){
        sr.addStudentTeacherPairToDb(studentName,teacherName);
    }

    Student getStudentByNameService(String studentName){
        return sr.getStudentByNameFromDb(studentName);
    }

    Teacher getTeacherByNameService(String teacherName){
        return sr.getTeacherByNameFromDb(teacherName);
    }

    List<String> getStudentsByTeacherNameService(String teacherName){
        return sr.getStudentsByTeacherNameFromDb(teacherName);
    }

    List<String> getAllStudentsService(){
        return sr.getAllStudentsFromDb();
    }
    void deleteTeacherBynameService(String teacherName){
        sr.deleteTeacherByNameFromDb(teacherName);
    }

    void deleteAllTeachersService(){
        sr.deleteAllTeachers();
    }
}
