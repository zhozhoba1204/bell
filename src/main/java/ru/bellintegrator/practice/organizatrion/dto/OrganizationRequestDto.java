package ru.bellintegrator.practice.organizatrion.dto;
import javax.validation.constraints.NotEmpty;

public class OrganizationRequestDto {
    @NotEmpty(message = "name cannot be null")
    public String name;
    public String inn;
    public Boolean isActive;

    public OrganizationRequestDto(String name, String inn, Boolean isActive) {
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Boolean asActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
