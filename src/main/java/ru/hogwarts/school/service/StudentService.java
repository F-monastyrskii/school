package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent (Student student);

    Student getStudent (long id);

    Student editStudent(long id, Student student);

    List<Student> getAllStudents();

    void deleteStudent (long id);

    List<Student> findByAgeBetween(int min, int max);
}

