package hogwarts.hogwarts.service;

import hogwarts.hogwarts.entities.Student;

public interface StudentService {

    Student addStudent(Student student);

    Student findStudent(long id);

    Student editStudent(long id, Student student);

    void deleteStudent(long id);
}
