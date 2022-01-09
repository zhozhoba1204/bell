package ru.bellintegrator.practice.documents.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

/**
 * Тип документа
 */
@Entity
@Table(name = "Document_type")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_name")
    private String docName;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Код документа
     */
    @Column(name = "doc_code", length = 2, nullable = false)
    private Integer docCode;

    /**
     * Список конкретных документов
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "docType")
    private List<DocumentInfo> documents;

    /**
     * Конструктор для hibernate
     */
    public DocumentType() {
    }
    /**
     * Конструктор
     * @param docName
     * @param docCode
     */
    public DocumentType(String docName, Integer docCode) {
        this.docName = docName;
        this.docCode = docCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getDocCode() {
        return docCode;
    }

    public void setDocCode(Integer docCode) {
        this.docCode = docCode;
    }
}
