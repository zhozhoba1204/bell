package ru.bellintegrator.practice.office.dto;

import ru.bellintegrator.practice.office.model.OfficeEntity;
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

    public OfficeUpdateDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public OfficeUpdateDto(Integer id, String name, String address, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public static OfficeUpdateDto getUpdateDtoFromOffice(OfficeEntity office){
        return new OfficeUpdateDto(office.getId(), office.getName(), office.getAddress(),
                office.getPhone(), office.asActive());
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
