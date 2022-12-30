package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb = new HashMap<>();

    HashMap<String,Teacher> teacherDb = new HashMap<>();

    HashMap<String, List<String>> studentTeacherPair = new HashMap<>();

    void addStudentToDb(Student student){
        studentDb.put(student.getName(),student);
    }

    void addTeacherToDb(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
    }
    void addStudentTeacherPairToDb(String studentName,String teacherName){
        if(studentDb.containsKey(studentName) && teacherDb.containsKey(teacherName)){
            if(studentTeacherPair.containsKey(teacherName)) studentTeacherPair.get(teacherName).add(studentName);
            else{
                List<String> studentList=new ArrayList<String>();
                studentList.add(studentName);
                studentTeacherPair.put(teacherName,studentList);
            }
        }
    }

    Student getStudentByNameFromDb(String studentName){
        return studentDb.get(studentName);
    }

    Teacher getTeacherByNameFromDb(String teacherName){
        return teacherDb.get(teacherName);
    }

    List<String> getStudentsByTeacherNameFromDb(String teacherName){
        return studentTeacherPair.get(teacherName);
    }

    List<String> getAllStudentsFromDb(){
        return new ArrayList<>(studentDb.keySet());
    }
    void deleteTeacherByNameFromDb(String teacherName){
        if(teacherDb.containsKey(teacherName)){
            if(studentTeacherPair.containsKey(teacherName)){
                List<String> res=studentTeacherPair.get(teacherName);
                for(String s:res){
                    studentDb.remove(s);
                }
                studentTeacherPair.remove(teacherName);
            }
            teacherDb.remove(teacherName);
        }
    }

    void deleteAllTeachers(){
        for(String teacherName:teacherDb.keySet()){
            if(studentTeacherPair.containsKey(teacherName)){
                List<String> studentList=studentTeacherPair.get(teacherName);
                for(String s:studentList){
                    studentDb.remove(s);
                }
                studentTeacherPair.remove(teacherName);
            }
        }
        teacherDb=new HashMap<>();
    }
}
