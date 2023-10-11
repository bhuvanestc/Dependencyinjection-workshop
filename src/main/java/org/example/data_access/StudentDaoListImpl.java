package org.example.data_access;
import org.example.models.Student;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StudentDaoListImpl implements StudentDao{
    List<Student> students;

    public StudentDaoListImpl(List<Student> students) {
        this.students = new ArrayList<>();
    }
    @Override
    public Student save(Student student) {
        students.add( student);
        return student;
    }
    @Override
    public Student find(int id) {
        return students
                .stream()
                .filter(a->a.getId()==id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Student> findAll() {
        return this.students;
    }
    @Override
    public Student delete(int id) {
        Student studenttodelete =find(id);
        if(studenttodelete!=null){
            students.remove(studenttodelete);
        }else {
            System.out.println("studenttodelete : " + studenttodelete);
        }

        return studenttodelete;
    }
}
