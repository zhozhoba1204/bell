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

    public static Organization getOrganizationFromUpdateDto(OrganizationUpdateDto org) {
        return new Organization(org.getId(), org.getName(),
                org.getFullName(), org.getInn(),
                org.getKpp(), org.getAddress(),
                org.getPhone(), org.isActive());
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
