package ru.bellintegrator.practice.documents;


import javax.persistence.*;

@Entity
@Table(name = "Document_info")
public class DocumentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_number")
    private String docNumber;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date", length = 50, nullable = false)
    private String docDate;

    /**
     * Наименование документа
     */
    @Column(name = "doc_name")
    private String docName;
    /**
     * Конструктор для hibernate
     */
    public DocumentInfo() {
    }

    /**
     * Конструктор
     */
    public DocumentInfo(String docNumber, String docDate, String docName) {
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Integer getVersion() {
        return version;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
}
