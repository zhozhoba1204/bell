package ru.bellintegrator.practice.citizenship.service;

import ru.bellintegrator.practice.citizenship.dto.CitizenshipDto;

import java.util.List;

/**
 * Сервисный слой для бизнес-логики Citizenship
 */
public interface CitizenshipService {
    /**
     * Получить все страны
     * @return список стран и их код
     */
    List<CitizenshipDto> all();
}
