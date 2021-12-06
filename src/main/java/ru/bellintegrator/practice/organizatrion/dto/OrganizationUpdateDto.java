package ru.bellintegrator.practice.organizatrion.dto;

import ru.bellintegrator.practice.organizatrion.model.Organization;

import javax.validation.constraints.NotEmpty;

public class OrganizationUpdateDto {
    @NotEmpty(message = "id cannot be null")
    public Integer id;
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

    public OrganizationUpdateDto() {

    }
    public OrganizationUpdateDto(Integer id, String name, String fullName, String inn, String kpp, String address, String phone, boolean active) {
       this.id = id;
       this.name = name;
       this.fullName = fullName;
       this.inn = inn;
       this.kpp = kpp;
       this.address = address;
       this.phone = phone;
       this.isActive = active;
    }


    public static OrganizationUpdateDto getUpdateDtoFromOrganization(Organization org) {
        return new OrganizationUpdateDto(org.getId(), org.getName(),
                org.getFullName(), org.getInn(),
                org.getKpp(), org.getAddress(),
                org.getPhone(), org.isActive());
    }
}
