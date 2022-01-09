package ru.bellintegrator.practice.documents.dao;

import ru.bellintegrator.practice.documents.model.DocumentInfo;
import ru.bellintegrator.practice.documents.model.DocumentType;

import java.util.List;

/**
 * DAO для работы с Document
 */
public interface DocumentDao {
    /**
     * Получить тип документа по коду
     * @param docCode
     * @return
     */
    DocumentType loadByDocCode(Integer docCode);

    /**
     * Получить список документов по коду документа
     * @param docCode
     * @return
     */
    List<DocumentInfo> loadByDocumentType(Integer docCode);

    /**
     * Изменить номер документа
     * @param id
     * @param docNumber
     */
    void updateDocNumber(Integer id, String docNumber);

    /**
     * Изменить дату выдачи документа
     * @param id
     * @param docDate
     */
    void updateDocDate(Integer id, String docDate);

    /**
     * Изменить название документа
     * @param id
     * @param docName
     */
    void updateDocName(Integer id, String docName);

    /**
     * Получить все документы
     * @return
     */
    List<DocumentType> all();
}
