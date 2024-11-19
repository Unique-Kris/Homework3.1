package hogwarts.hogwarts.controller;

import hogwarts.hogwarts.entities.Student;
import hogwarts.hogwarts.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")  // Переносим общий путь сюда
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")  // Путь теперь /student/{id}
    public Student getStudent(@PathVariable Long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {  // Исправил на createStudent
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student editStudent(@PathVariable Long id, @RequestBody Student student) {  // Исправил на editStudent
        return studentService.editStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}