package org.example.service;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentManagementConsoleImpl implements  StudentManagement{
    @Autowired
    private UserInputService scannerService;

    @Autowired
    private StudentDao studentDao;
    @Override
    public Student create() {
        return new Student();
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student student = this.find(id);
        Student deletedStudent = studentDao.delete(id);

        if (deletedStudent != null) {
            return deletedStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        studentDao.delete(student.getId());
        studentDao.save(student);
        return student;
    }
}
