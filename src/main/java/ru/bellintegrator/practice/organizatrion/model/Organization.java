package ru.bellintegrator.practice.organizatrion.model;

import ru.bellintegrator.practice.office.model.Office;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

/**
 * Организация
 */
@Entity
@Table(name = "Organization")
public class Organization {
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
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Полное название
     */
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    /**
     * Инн
     */
    @Column(name = "inn", length = 50, nullable = false)
    private String inn;

    /**
     * Кпп
     */
    @Column(name = "Kpp", length = 50, nullable = false)
    private String kpp;

    /**
     * Адрес
     */
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 10)
    private String phone;

    /**
     * Статус активности
     */
    @Column(name = "is_active")
    private boolean isActive;

    /**
     * Список офисов
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "organization")
    private List<Office> offices;

    /**
     * Конструктор
     */
    public Organization() {
    }

    /**
     * Конструктор
     * @param name
     * @param fullName
     * @param inn
     * @param kpp
     * @param address
     * @param phone
     * @param isActive
     */
    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    /**
     * Конструктор
     * @param id
     * @param name
     * @param fullName
     * @param inn
     * @param kpp
     * @param address
     * @param phone
     * @param isActive
     */
    public Organization(Integer id, String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<Office> getOffices() {
        return offices;
    }

    public boolean asActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        isActive = isActive;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

}
