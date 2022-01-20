package ru.bellintegrator.practice.citizenship.dto;

import ru.bellintegrator.practice.citizenship.model.CitizenshipEntity;

public class CitizenshipDto {
    String name;
    String code;

    public CitizenshipDto(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static CitizenshipDto getDtoFromCitizenship(CitizenshipEntity citizenship){
        return new CitizenshipDto(citizenship.getCitizenshipName(),citizenship.getCitizenshipCode());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
