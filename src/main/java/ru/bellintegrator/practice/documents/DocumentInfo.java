package ru.bellintegrator.practice.documents;

import ru.bellintegrator.practice.user.model.User;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.MapsId;


@Entity
@Table(name = "Document_info")
public class DocumentInfo {
    @Id
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Номер документа
     */
    @Column(name = "doc_number")
    private String docNumber;

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
     * Ассоциация с классом User
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

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
