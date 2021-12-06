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

    public static OrganizationResponseDto getDtoFromOrganization(Organization organization){
return new OrganizationResponseDto(organization.getId(), organization.getName(), organization.isActive());
    }

}
