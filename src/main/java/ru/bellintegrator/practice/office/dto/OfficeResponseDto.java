package ru.bellintegrator.practice.office.dto;

import ru.bellintegrator.practice.office.model.OfficeEntity;

public class OfficeResponseDto {

    public Integer id;
    public String name;
    public boolean isActive;

    public OfficeResponseDto(Integer id, String name, boolean isActive) {
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

    public static OfficeResponseDto getResponseDtoFromOffice(OfficeEntity office){
        return new OfficeResponseDto(office.getId(), office.getName(), office.asActive());
    }
}
