package com.example.restservice;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final List<Stud> students = new ArrayList<>();

    public StudentController() {
        students.add(new Stud(1, "Peter", "Arcanide DNA"));
        students.add(new Stud(2, "Ned", "Spidey Tracker"));
        students.add(new Stud(3, "Jean", "Telepathy"));
    }

    @GetMapping
    public List<Stud> getStudents() {
        return students;
    }

    @GetMapping("/{id}")
    public Stud getStudent(@PathVariable int id) {
        for (Stud student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    @PostMapping
    public Stud addStudent(@RequestBody Stud student) {
        students.add(student);
        return student;
    }

    @PutMapping("/{id}")
    public Stud updateStudent(
            @PathVariable int id,
            @RequestBody Stud updateStud) {

        for (Stud student : students) {
            if (student.getId() == id) {
                student.setName(updateStud.getName());
                student.setSource(updateStud.getCourse());
                return student;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {

        boolean deleted =
                students.removeIf(student -> student.getId() == id);

        if (deleted) {
            return "Student deleted successfully";
        }

        return "Student not found";
    }
}
