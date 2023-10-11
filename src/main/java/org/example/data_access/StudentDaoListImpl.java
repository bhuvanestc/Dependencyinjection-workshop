package org.example.data_access;
import org.example.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoListImpl implements StudentDao{
    List<Student> students;

    public StudentDaoListImpl(List<Student> students) {
        this.students = new ArrayList<>();
    }

    public Student save(Student student) {
        students.add( student);
        return student;
    }

    public Student find(int id) {
        return students
                .stream()
                .filter(a->a.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> findAll() {
        return this.students;
    }

    public void delete(int id) {
        Student studenttodelete =find(id);
        if(studenttodelete!=null){
            students.remove(studenttodelete);
        }else {
            System.out.println("studenttodelete : " + studenttodelete);
        }

    }
}
