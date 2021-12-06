package ru.bellintegrator.practice.office.dto;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationResponseDto;
import ru.bellintegrator.practice.organizatrion.model.Organization;

public class OfficeResponseDto {

    public Integer id;
    public String name;
    public boolean isActive;

    public OfficeResponseDto(Integer id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public static OfficeResponseDto getResponceDtoFromOffice(Office office){
        return new OfficeResponseDto(office.getId(), office.getName(), office.isActive());
    }
}
