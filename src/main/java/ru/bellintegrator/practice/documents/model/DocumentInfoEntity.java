package ru.bellintegrator.practice.documents.model;

import ru.bellintegrator.practice.user.model.UserEntity;
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
public class DocumentInfoEntity implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UserEntity user;

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
    private DocumentTypeEntity docType;

    /**
     * Конструктор
     */
    public DocumentInfoEntity() {
    }
    /**
     * Конструктор
     * @param docNumber
     * @param docDate
     * @param docName
     */
    public DocumentInfoEntity(String docNumber, String docDate, String docName) {
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.docName = docName;
    }
    /**
     * Конструктор
     * @param docNumber
     * @param docDate
     */
    public DocumentInfoEntity(String docNumber, String docDate) {
        this.docNumber = docNumber;
        this.docDate = docDate;
    }
    /**
     * Конструктор
     * @param docNumber
     */
    public DocumentInfoEntity(String docNumber) {
        this.docNumber = docNumber;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
