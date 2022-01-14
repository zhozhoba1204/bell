package ru.bellintegrator.practice.organizatrion.dto;
import javax.validation.constraints.NotEmpty;

public class OrganizationRequestDto {
    @NotEmpty(message = "name cannot be null")
    public String name;
    public String inn;
    public boolean isActive;

    public OrganizationRequestDto(String name, String inn, boolean isActive) {
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

    public boolean asActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
