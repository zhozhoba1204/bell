package ru.bellintegrator.practice.documents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.documents.dto.DocumentDto;
import ru.bellintegrator.practice.documents.service.DocService;
import java.util.List;

/**
 * Контроллер для работы с Document
 */
@RestController
public class DocumentController {

    private final DocService docService;

    @Autowired
    public DocumentController(DocService docService) {
        this.docService = docService;
    }

    /**
     * Получить справочник всех документов
     * @return
     */
    @PostMapping("api/docs")
    public List<DocumentDto> all(){
        List<DocumentDto> result = docService.all();
        return result;
    }
}
