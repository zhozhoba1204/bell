package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.citizenship.model.Citizenship;
import ru.bellintegrator.practice.documents.model.DocumentInfo;
import ru.bellintegrator.practice.office.model.Office;
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
public class User {
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
    private DocumentInfo documentInfo;

    /**
     * Связь с Office
     */
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Связь с Citizenship
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "citizenship_id")
    private Citizenship citizenship;

    /**
     * Статус идентификации
     */
    @Column(name = "is_identified")
    private boolean isIdentified;

    /**
     * Конструктор
     */
    public User() {
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
    public User(String firstName, String middleName, String lastName, String position, String phone, boolean isIdentified) {
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
    public User(String firstName, String middleName, String lastName, String position,
                String phone, DocumentInfo documentInfo, Office office, Citizenship citizenship,
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

    public DocumentInfo getDocumentInfo() {
        return documentInfo;
    }

    public void setDocumentInfo(DocumentInfo documentInfo) {
        this.documentInfo = documentInfo;
    }
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public boolean asIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(boolean identified) {
        isIdentified = identified;
    }
}
