package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeResponseDto;
import ru.bellintegrator.practice.office.dto.OfficeSaveDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;

import java.util.List;

/**
 * Сервисный слой для работы с Office
 */
public interface OfficeService {
    /**
     * Получить офисы по заданному фильтру
     * @param officeRequestDto
     * @return
     */
    List<OfficeResponseDto> filter(OfficeRequestDto officeRequestDto);

    /**
     * Получить офис по id
     * @param id
     * @return
     */
    OfficeUpdateDto loadById(Integer id);

    /**
     * Изменить офис
     * @param officeUpdateDto
     */
    void update(OfficeUpdateDto officeUpdateDto);

    /**
     * Сохранить новый офис
     * @param officeSaveDto
     */
    void save(OfficeSaveDto officeSaveDto);
}
