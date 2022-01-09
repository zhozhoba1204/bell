package ru.bellintegrator.practice.documents.service;

import ru.bellintegrator.practice.documents.dto.DocumentDto;
import java.util.List;

/**
 * Сервисный слой для бизнес-логики с Document
 */
public interface DocService {
    /**
     * Получить все документы
     * @return
     */
    List<DocumentDto> all();
}
