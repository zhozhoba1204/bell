package ru.bellintegrator.practice.organizatrion.dto;
import javax.validation.constraints.NotEmpty;

public class OrganizationRequestDto {
    @NotEmpty(message = "name cannot be null")
    public String name;
    public String inn;
    public boolean isActive;
}
