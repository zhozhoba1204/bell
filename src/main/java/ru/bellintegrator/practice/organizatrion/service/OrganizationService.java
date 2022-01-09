package ru.bellintegrator.practice.organizatrion.service;

import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationResponseDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import java.util.List;

/**
 * Сервисный слой для бизнес-логики с Organization
 */
public interface OrganizationService {
    /**
     * Получить список организаций по заданному фильтру
     * @param organizationRequestDto
     * @return
     */
    List<OrganizationResponseDto> filter(OrganizationRequestDto organizationRequestDto);

    /**
     * Получить организацию по id
     * @param id
     * @return
     */
    OrganizationUpdateDto loadById(Integer id);

    /**
     * Изменить организацию
     * @param organizationUpdateDto
     */
    void update(OrganizationUpdateDto organizationUpdateDto);

    /**
     * Сохранить организацию
     * @param organizationSaveDto
     */
    void save(OrganizationSaveDto organizationSaveDto);
}
