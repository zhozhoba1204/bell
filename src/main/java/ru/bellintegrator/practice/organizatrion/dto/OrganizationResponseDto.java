package ru.bellintegrator.practice.organizatrion.dto;

import ru.bellintegrator.practice.organizatrion.model.Organization;

public class OrganizationResponseDto {

    public Integer id;
    public String name;
    public boolean isActive;

    public OrganizationResponseDto(Integer id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static OrganizationResponseDto getDtoFromOrganization(Organization organization){
return new OrganizationResponseDto(organization.getId(), organization.getName(), organization.isActive());
    }

    @Override
    public String toString() {
        return "name: " + name + "," + '\'' +
                "isActive: " + isActive + '\'' +
                '}';
    }
}
