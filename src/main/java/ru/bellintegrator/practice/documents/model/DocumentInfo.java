package ru.bellintegrator.practice.documents.model;

import ru.bellintegrator.practice.user.model.User;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;
import java.io.Serializable;

/**
 * Информация о документах
 */
@Entity
@Table(name = "Document_info")
public class DocumentInfo implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

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
    @Column(name = "doc_date", length = 50)
    private String docDate;

    /**
     * Наименование документа
     */
    @Column(name = "doc_name")
    private String docName;

    /**
     * Связь с классом User
     */
    @ManyToOne
    @JoinColumn(name = "doc_name",insertable = false,updatable = false)
    private DocumentType docType;

    /**
     * Конструктор
     */
    public DocumentInfo() {
    }
    /**
     * Конструктор
     * @param docNumber
     * @param docDate
     * @param docName
     */
    public DocumentInfo(String docNumber, String docDate, String docName) {
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.docName = docName;
    }
    /**
     * Конструктор
     * @param docNumber
     * @param docDate
     */
    public DocumentInfo(String docNumber, String docDate) {
        this.docNumber = docNumber;
        this.docDate = docDate;
    }
    /**
     * Конструктор
     * @param docNumber
     */
    public DocumentInfo(String docNumber) {
        this.docNumber = docNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
