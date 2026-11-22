package ru.hogwarts.school.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FacultyDto {
    private Long id;

    @NotBlank(message = "Название факультета не может быть пустым")
    @Size(min = 2, max = 50, message = "Название должно быть от 2 до 50 символов")
    private String name;

    @NotBlank(message = "Цвет факультета не может быть пустым")
    private String color;

    public FacultyDto() {}

    public FacultyDto(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}


