package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty);

    Faculty getFaculty(long id);

    Faculty editFaculty(long id, Faculty faculty);

    void deleteFaculty(long id) ;

    List<Student> getFacultyStudents(long id);

    List<Faculty> searchFacultiesByNameOrColor(String query);
}
