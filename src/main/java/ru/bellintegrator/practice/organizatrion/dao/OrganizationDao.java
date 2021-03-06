package ru.bellintegrator.practice.organizatrion.dao;

import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.OrganizationEntity;
import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Получить все объекты Organization по фильтру
     *
     * @return список организаций
     */
    List<OrganizationEntity> filter(OrganizationRequestDto organizationRequestDto);
    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    OrganizationEntity loadById(Integer id);
    /**
     * Редактировать Organization
     *
     * @param
     */
    void update(OrganizationUpdateDto organization);
    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(OrganizationEntity organization);
}
