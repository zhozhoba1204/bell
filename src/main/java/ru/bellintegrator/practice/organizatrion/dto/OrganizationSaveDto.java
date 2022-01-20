package ru.bellintegrator.practice.organizatrion.dto;

import ru.bellintegrator.practice.organizatrion.model.OrganizationEntity;
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

    public OrganizationSaveDto(String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OrganizationSaveDto(String name) {
        this.name = name;
    }

    public static OrganizationEntity getOrganizationFromSaveDto(OrganizationSaveDto orgSaveDto) {
        return new OrganizationEntity(orgSaveDto.name,
                orgSaveDto.fullName, orgSaveDto.inn,
                orgSaveDto.kpp, orgSaveDto.address,
                orgSaveDto.phone, orgSaveDto.isActive);

    }
}
