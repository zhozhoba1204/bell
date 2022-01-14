package ru.bellintegrator.practice.office.dto;

import ru.bellintegrator.practice.office.model.Office;
import javax.validation.constraints.NotEmpty;

public class OfficeUpdateDto {
    @NotEmpty(message = "id cannot be null")
    public Integer id;
    @NotEmpty(message = "name cannot be null")
    public String name;
    @NotEmpty(message = "address cannot be null")
    public String address;
    public String phone;
    public boolean isActive;

    public OfficeUpdateDto() {
    }

    public OfficeUpdateDto(Integer id, String name, String address, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public static OfficeUpdateDto getOfficeFromUpdateDto(Office office){
        return new OfficeUpdateDto(office.getId(), office.getName(), office.getAddress(),
                office.getPhone(), office.asActive());
    }
}
