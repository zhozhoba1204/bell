package ru.bellintegrator.practice.organizatrion.dao;

import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import java.util.List;
/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Получить все объекты Organization по фильтру
     *
     * @return
     */
    List<Organization> filter(OrganizationRequestDto organizationRequestDto);
    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Integer id);
    /**
     * Редактировать Organization
     *
     * @param organizationDto
     */
    void update(OrganizationUpdateDto organization);
    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);
}
