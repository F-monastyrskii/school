package ru.hogwarts.school.mapper;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.FacultyDto;
import ru.hogwarts.school.model.Faculty;

@Component
public class FacultyMapper {
    public FacultyDto toDto(Faculty faculty) {
        if (faculty == null) return null;
        return new FacultyDto(
                faculty.getId(),
                faculty.getName(),
                faculty.getColor()
        );
    }

    public Faculty toEntity(FacultyDto dto) {
        if (dto == null) return null;
        Faculty faculty = new Faculty();
        faculty.setId(dto.getId() != null ? dto.getId() : 0L);
        faculty.setName(dto.getName());
        faculty.setColor(dto.getColor());
        return faculty;
    }
}
