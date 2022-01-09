package ru.bellintegrator.practice.citizenship.dao;

import ru.bellintegrator.practice.citizenship.model.Citizenship;

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
    Citizenship loadByCitizenshipCode(String citizenshipCode);

    /**
     * Получить все страны из справочника
     * @return
     */
    List<Citizenship> all();
}
