package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@Tag(name = "FacultyController", description = "управление факультутами")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/search")

    @Operation(
            summary = "Поиск факултетов по имени и цвету",
            description = "Возвращает список факультетов, у которых имя и цвет содержат указанную строку")
    public ResponseEntity<List<Faculty>> searchFaculties (
            @Parameter(description = "Строка для поиска по имени или цвету") @RequestParam String query) {
                List<Faculty> faculties = facultyService.searchFacultiesByNameOrColor(query);
                return ResponseEntity.ok(faculties);
    }

    @GetMapping("/{id}/students")
    @Operation(
            summary = "Получить студентов факультута",
            description = "возвращает список студентов, привязанных к указанному факультету")
    public ResponseEntity<List<Student>> getFacultyStudents(
            @Parameter(description = "ID факультета") @PathVariable long id) {
        List<Student> students = facultyService.getFacultyStudents(id);
        return ResponseEntity.ok(students);
    }

    @PostMapping
    @Operation(
            summary = "Создать новый факультет",
            description = "Создает новый факультет в системе"
    )
    @ApiResponse(responseCode = "201", description = "Факультет успешно создан")
    ResponseEntity <Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.addFaculty(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFaculty);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить факультет по ID",
            description = "Возвращает факультет по указанному идентификатору"
    )
    @ApiResponse(responseCode = "200", description = "Факультет найден")
    @ApiResponse(responseCode = "404", description = "Факультет не найден")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Faculty foundFaculty = facultyService.getFaculty(id);
        return ResponseEntity.status(HttpStatus.OK).body(foundFaculty);
    }

    @PutMapping("{id} ")
    public ResponseEntity<Faculty> editFaculty(@PathVariable Long id,@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(id, faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
}
