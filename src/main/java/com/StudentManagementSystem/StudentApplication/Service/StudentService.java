package com.StudentManagementSystem.StudentApplication.Service;

import com.StudentManagementSystem.StudentApplication.Entity.Student;
import com.StudentManagementSystem.StudentApplication.Repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentDao studentDao;
    public StudentService (StudentDao studentDao){
        this.studentDao=studentDao;
    }
    public List<Student> getAll(){
        if(studentDao.findAll().size() > 0){
            return studentDao.findAll();
        }
        return null;

    }
    public Student getStudent(int id){
        if(studentDao.getStudent(id) != null){
            return studentDao.getStudent(id);
        }
        return null;
    }
    public Student addStudent(Student student){
        if(studentDao.getStudent(student.getId()) == null) {
            studentDao.saveStudent(student);
            return student;
        }
        return null;

    }
    public Student updateStudent(Student student){
        if(studentDao.getStudent(student.getId())!=null){
            studentDao.updateStudent(student);
            return student;
        }
        return null;
    }
    public boolean deleteStudent(int id){
        if(studentDao.getStudent(id) != null){
            studentDao.deleteStudent(id);
            return true;
        }
        return false;
    }
}
