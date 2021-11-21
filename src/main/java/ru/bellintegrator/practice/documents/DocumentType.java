package ru.bellintegrator.practice.documents;

import javax.persistence.*;

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
    private String docCode;

    /**
     * Конструктор для hibernate
     */
    public DocumentType() {
    }

    /**
     * Конструктор
     */
    public DocumentType(String docName, String docCode) {
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

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }
}
