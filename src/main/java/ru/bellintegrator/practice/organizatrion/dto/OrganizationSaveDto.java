package ru.bellintegrator.practice.organizatrion.dto;

import ru.bellintegrator.practice.organizatrion.model.Organization;
import javax.validation.constraints.NotEmpty;

public class OrganizationSaveDto {
    @NotEmpty(message = "name cannot be null")
    public String name;
    @NotEmpty(message = "fullName cannot be null")
    public String fullName;
    @NotEmpty(message = "inn cannot be null")
    public String inn;
    @NotEmpty(message = "kpp cannot be null")
    public String kpp;
    @NotEmpty(message = "address cannot be null")
    public String address;
    public String phone;
    public boolean isActive;

    public static Organization getOrganizationFromSaveDto(OrganizationSaveDto orgSaveDto) {
        return new Organization(orgSaveDto.name,
                orgSaveDto.fullName, orgSaveDto.inn,
                orgSaveDto.kpp, orgSaveDto.address,
                orgSaveDto.phone, orgSaveDto.isActive);

    }
}
