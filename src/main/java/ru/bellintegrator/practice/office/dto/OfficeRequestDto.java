package ru.bellintegrator.practice.office.dto;
import javax.validation.constraints.NotEmpty;

public class OfficeRequestDto {
    @NotEmpty(message = "org_id cannot be null")
    public Integer orgId;
    public String name;
    public String phone;
    public boolean isActive;

    public OfficeRequestDto() {
    }

    public OfficeRequestDto(Integer orgId, String name, String phone, boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.phone = phone;
        this.isActive = isActive;
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
