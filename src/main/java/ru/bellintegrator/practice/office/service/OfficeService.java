package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeResponseDto;
import ru.bellintegrator.practice.office.dto.OfficeSaveDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import java.util.List;

public interface OfficeService {
    List<OfficeResponseDto> filter(OfficeRequestDto officeRequestDto);

    OfficeUpdateDto loadById(Integer id);

    void update(OfficeUpdateDto officeUpdateDto);

    void save(OfficeSaveDto officeSaveDto);
}
