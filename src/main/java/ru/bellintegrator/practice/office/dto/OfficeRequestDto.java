package ru.bellintegrator.practice.office.dto;
import javax.validation.constraints.NotEmpty;

public class OfficeRequestDto {
    @NotEmpty(message = "org_id cannot be null")
    public Integer orgId;
    public String name;
    public String phone;
    public boolean isActive;
}
