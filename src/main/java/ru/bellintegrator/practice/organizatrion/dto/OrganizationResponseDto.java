package ru.bellintegrator.practice.organizatrion.dto;

import ru.bellintegrator.practice.organizatrion.model.OrganizationEntity;

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

    public boolean asActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        isActive = isActive;
    }

    public static OrganizationResponseDto getDtoFromOrganization(OrganizationEntity organization){
return new OrganizationResponseDto(organization.getId(), organization.getName(), organization.asActive());
    }

}
