package ru.bellintegrator.practice.office.dto;

import ru.bellintegrator.practice.office.model.OfficeEntity;
import ru.bellintegrator.practice.organizatrion.model.OrganizationEntity;
import javax.validation.constraints.NotEmpty;

public class OfficeSaveDto {
        @NotEmpty(message = "org_id cannot be null")
        public Integer orgId;
        public String name;
        public String address;
        public String phone;
        public boolean isActive;

    public OfficeSaveDto() {
    }

    public OfficeSaveDto(Integer orgId, String name, String address, String phone, boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OfficeSaveDto(String name) {
        this.name = name;
    }

    public static OfficeEntity getOfficeFromSaveDto(OrganizationEntity organization, OfficeSaveDto officeSaveDto) {
            return new OfficeEntity(officeSaveDto.name, organization, officeSaveDto.address,
                    officeSaveDto.phone, officeSaveDto.isActive);
        }

    public Integer getOrgId() {
        return orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean asActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
