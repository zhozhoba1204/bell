package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;
import ru.bellintegrator.practice.office.model.OfficeEntity;
import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {

    /**
     * Получить все объекты Office по фильтру
     *
     * @return
     */
    List<OfficeEntity> filter(OfficeRequestDto officeRequestDto);

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    OfficeEntity loadById(Integer id);

    /**
     * Редактировать Office
     *
     * @param officeUpdateDto
     */
    void update(OfficeUpdateDto officeUpdateDto);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void save(OfficeEntity office);
}
