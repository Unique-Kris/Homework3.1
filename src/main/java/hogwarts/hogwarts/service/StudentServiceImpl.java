package hogwarts.hogwarts.service;

import hogwarts.hogwarts.model.Student;
import hogwarts.hogwarts.exception.NotFoundStudentException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentServiceImpl implements StudentService{

    private final HashMap<Long, Student> students = new HashMap<>();
    private long count = 0;

    public Student addStudent(Student student) {
        student.setId(count++);
        students.put(student.getId(), student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Student editStudent(long id, Student student) {
        if (students.containsKey(id)) {
            throw new NotFoundStudentException();
        }
        students.put(id,student);
        return student;
    }

    public void deleteStudent(long id) {
        students.remove(id);
    }
}
