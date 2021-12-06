package ru.bellintegrator.practice.office.dto;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import javax.validation.constraints.NotEmpty;

public class OfficeSaveDto {
        @NotEmpty(message = "org_id cannot be null")
        public Integer orgId;
        public String name;
        public String address;
        public String phone;
        public boolean isActive;

        public static Office getOfficeFromSaveDto(Organization organization, OfficeSaveDto officeSaveDto) {
            return new Office(officeSaveDto.name, organization, officeSaveDto.address,
                    officeSaveDto.phone, officeSaveDto.isActive);
        }
    }
