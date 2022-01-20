package ru.bellintegrator.practice.documents.dto;

import ru.bellintegrator.practice.documents.model.DocumentTypeEntity;

public class DocumentDto {
    String name;
    Integer code;

    public DocumentDto(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static DocumentDto getDtoFromDocument(DocumentTypeEntity documentType){
        return new DocumentDto(documentType.getDocName(),documentType.getDocCode());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
