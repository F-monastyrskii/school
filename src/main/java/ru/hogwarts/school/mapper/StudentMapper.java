package ru.hogwarts.school.mapper;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.model.Student;

@Component
public class StudentMapper {
    public StudentDto toDto(Student student) {
        if (student == null) return null;
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getAge()
        );
    }

    public Student toEntity(StudentDto dto) {
        if (dto == null) return null;
        Student student = new Student();
        student.setId(dto.getId() != null ? dto.getId() : 0L);
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        return student;
    }
}
