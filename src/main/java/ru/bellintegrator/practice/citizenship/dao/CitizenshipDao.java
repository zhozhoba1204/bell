package ru.bellintegrator.practice.citizenship.dao;

import ru.bellintegrator.practice.citizenship.model.CitizenshipEntity;

import java.util.List;

/**
 * DAO для работы с Citizenship
 */
public interface CitizenshipDao {
    /**
     * Найти страну по коду
     * @param citizenshipCode
     * @return
     */
    CitizenshipEntity loadByCitizenshipCode(String citizenshipCode);

    /**
     * Получить все страны из справочника
     * @return
     */
    List<CitizenshipEntity> all();
}
