package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.citizenship.model.CitizenshipEntity;
import ru.bellintegrator.practice.documents.model.DocumentInfoEntity;
import ru.bellintegrator.practice.office.model.OfficeEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

/**
 * Пользователь
 */
@Entity
@Table(name = "Usr")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя
     */
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 50, nullable = false)
    private String middleName;

    /**
     * Фамилия
     */
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    /**
     * Должность
     */
    @Column(name = "position", length = 50, nullable = false)
    private String position;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

    /**
     * Связь с DocumentInfo
     */
    @OneToOne(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false
    )
    private DocumentInfoEntity documentInfo;

    /**
     * Связь с Office
     */
    @ManyToOne
    @JoinColumn(name = "office_id")
    private OfficeEntity office;

    /**
     * Связь с Citizenship
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "citizenship_id")
    private CitizenshipEntity citizenship;

    /**
     * Статус идентификации
     */
    @Column(name = "is_identified")
    private boolean isIdentified;

    /**
     * Конструктор
     */
    public UserEntity() {
    }

    /**
     * Конструктор для тестов
     * @param firstName
     * @param middleName
     * @param lastName
     * @param position
     * @param phone
     * @param isIdentified
     */
    public UserEntity(String firstName, String middleName, String lastName, String position, String phone, boolean isIdentified) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
    }

    /**
     * Конструктор
     * @param firstName
     * @param middleName
     * @param lastName
     * @param position
     * @param phone
     * @param documentInfo
     * @param office
     * @param citizenship
     * @param isIdentified
     */
    public UserEntity(String firstName, String middleName, String lastName, String position,
                      String phone, DocumentInfoEntity documentInfo, OfficeEntity office, CitizenshipEntity citizenship,
                      boolean isIdentified) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.documentInfo = documentInfo;
        this.office = office;
        this.citizenship = citizenship;
        this.isIdentified = isIdentified;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DocumentInfoEntity getDocumentInfo() {
        return documentInfo;
    }

    public void setDocumentInfo(DocumentInfoEntity documentInfo) {
        this.documentInfo = documentInfo;
    }
    public OfficeEntity getOffice() {
        return office;
    }

    public void setOffice(OfficeEntity office) {
        this.office = office;
    }

    public CitizenshipEntity getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(CitizenshipEntity citizenship) {
        this.citizenship = citizenship;
    }

    public boolean asIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(boolean identified) {
        isIdentified = identified;
    }
}
